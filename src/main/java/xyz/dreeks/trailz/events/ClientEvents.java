package xyz.dreeks.trailz.events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import xyz.dreeks.trailz.gui.GuiTrailSelector;
import xyz.dreeks.trailz.utils.TrailzKeybinds;

public class ClientEvents {

    @SubscribeEvent
    public void onKeyInput(KeyInputEvent event)
    {
        if (TrailzKeybinds.SHOW_GUI.isPressed())
        {
            Minecraft.getMinecraft().displayGuiScreen(new GuiTrailSelector());
        }
    }
    
    public static void register() {
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
    }

}