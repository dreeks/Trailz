package xyz.dreeks.trailz.network;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import xyz.dreeks.trailz.trails.Trail;
import xyz.dreeks.trailz.trails.TrailsLoader;

public class HandlerUploadTrails implements IMessageHandler<PacketUploadTrails, IMessage> {

  @Override
  public IMessage onMessage(PacketUploadTrails message, MessageContext ctx) {
        Trail received = message.getTrail();
        TrailsLoader.write(received);
        return null;
  }

}