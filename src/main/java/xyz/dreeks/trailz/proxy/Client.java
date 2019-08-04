package xyz.dreeks.trailz.proxy;

import xyz.dreeks.trailz.events.ClientEvents;
import xyz.dreeks.trailz.utils.TrailzKeybinds;

public class Client implements IProxy {

    public void registerRenders() {

    }

    public void registerNetwork() {
        ClientEvents.register();
        TrailzKeybinds.register();
    }

    public boolean isClient() {
        return true;
    }


}