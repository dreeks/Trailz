package xyz.dreeks.trailz.events;

import net.minecraftforge.common.MinecraftForge;

public class TrailzEvents {

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new TrailzEvents());
    }

}