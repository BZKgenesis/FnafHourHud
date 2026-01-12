package net.bzkgns.fnafhourhudmod;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ScoreSyncPacket {

    private final int isEnabled;
    private final int time;

    public ScoreSyncPacket(int isEnabled, int time) {
        this.isEnabled = isEnabled;
        this.time = time;

    }

    // Encode
    public static void encode(ScoreSyncPacket msg, FriendlyByteBuf buf) {

        buf.writeInt(msg.isEnabled);
        buf.writeInt(msg.time);
    }

    // Decode
    public static ScoreSyncPacket decode(FriendlyByteBuf buf) {
        return new ScoreSyncPacket(buf.readInt(),buf.readInt());
    }

    // Handle CLIENT
    public static void handle(ScoreSyncPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ClientScoreData.setIsEnabled(msg.isEnabled);
            ClientScoreData.setTime(msg.time);
        });
        ctx.get().setPacketHandled(true);
    }
}
