package xyz.dreeks.trailz.utils;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class TrailzKeybinds {

    public static KeyBinding SHOW_GUI;

    public static void register() {
        ClientRegistry.registerKeyBinding(SHOW_GUI = new KeyBinding("key.show_gui", Keyboard.KEY_V, "key.categories.trailz"));
    }

}