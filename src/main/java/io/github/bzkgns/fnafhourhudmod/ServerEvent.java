package io.github.bzkgns.fnafhourhudmod;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Score;
import net.minecraft.world.scores.Scoreboard;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(
        modid = FnafHourHudMod.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class ServerEvent {
    private static final Map<String, Integer> LAST_VALUE = new HashMap<>();

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.player == null || event.player.level().isClientSide()) return;

        ServerPlayer player = (ServerPlayer) event.player;

        Scoreboard scoreboard = event.player.getScoreboard();
        Objective obj = scoreboard.getObjective("fnafhourhud.main");
        if (obj == null) return;


        String enableName = "isEnabled";
        Score enableScore = scoreboard.getOrCreatePlayerScore(enableName, obj);
        int enableValue = enableScore.getScore();
        int enableLast = LAST_VALUE.getOrDefault(enableName, Integer.MIN_VALUE);

        String timeName = "time";
        Score timeScore = scoreboard.getOrCreatePlayerScore(timeName, obj);
        int timeValue = timeScore.getScore();
        int timeLast = LAST_VALUE.getOrDefault(timeName, Integer.MIN_VALUE);

        if (enableValue == enableLast && timeValue == timeLast) return;
        LAST_VALUE.put(enableName, enableValue);
        LAST_VALUE.put(timeName, timeValue);
        ModNetwork.CHANNEL.send(
                PacketDistributor.PLAYER.with(() -> player),
                new ScoreSyncPacket(enableValue,timeValue)
        );
    }
}
