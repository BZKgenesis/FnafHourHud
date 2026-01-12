package net.bzkgns.fnafhourhudmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.bzkgns.fnafhourhudmod.FnafHourHudMod.FNAF_FONT;

@Mod.EventBusSubscriber(
        modid = FnafHourHudMod.MOD_ID,
        value = Dist.CLIENT,
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class HudOverlay {

    @SubscribeEvent
    public static void onRenderGui(RenderGuiOverlayEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null) return;

        int enableValue = ClientScoreData.getIsEnabled();
        if (enableValue != 1) return; // n'affiche rien si la valeur n'est pas 1


        int timeValue = ClientScoreData.getTime();

        int screenWidth = mc.getWindow().getGuiScaledWidth();
        int x = screenWidth - 10;
        int y = 10;



        Component text = Component.literal(timeValue + " AM")
                .withStyle(style -> style.withFont(FNAF_FONT));

        Font font = mc.font;

        int textWidth = font.width(text);

        event.getGuiGraphics().drawString(font, text, x - textWidth, y, 0xFFFFFF, false);
    }
}
