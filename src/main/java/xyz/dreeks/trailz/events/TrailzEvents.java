package xyz.dreeks.trailz.events;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.dreeks.trailz.Trailz;
import xyz.dreeks.trailz.network.PacketUploadTrails;
import xyz.dreeks.trailz.network.TrailzNetwork;
import xyz.dreeks.trailz.utils.Constants;

public class TrailzEvents {

    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {
        event.getEntityPlayer().sendMessage(new TextComponentString("Pickedup " + Trailz.TMP_SIDE));
        System.out.println("Pickedup " + Trailz.TMP_SIDE);

        if (Trailz.TMP_SIDE.toString().equals("CLIENT")) {
            TrailzNetwork.INSTANCE.sendToServer(new PacketUploadTrails(Constants.TRAILS.get(0)));
        }
    }

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new TrailzEvents());
    }

}