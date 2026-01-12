package net.bzkgns.fnafhourhudmod;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModNetwork {
    public static final String PROTOCOL = "1";
    public static SimpleChannel CHANNEL;

    public static void init() {
        CHANNEL = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(FnafHourHudMod.MOD_ID, "network"),
                () -> "1",
                s->true,
                s->true
        );

        int id = 0;
        CHANNEL.registerMessage(
                id++,
                ScoreSyncPacket.class,
                ScoreSyncPacket::encode,
                ScoreSyncPacket::decode,
                ScoreSyncPacket::handle
        );
    }
}
