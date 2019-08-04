package xyz.dreeks.trailz.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import xyz.dreeks.trailz.trails.Trail;

public class PacketUploadTrails implements IMessage {

    private Trail trail;

    public PacketUploadTrails(Trail t) {
        this.trail = t;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        Trail t = new Trail();
        t.setName(TrailzNetwork.readString(buf));
        t.setCreator(TrailzNetwork.readString(buf));
        t.setUUID(TrailzNetwork.readString(buf));
        t.setTexture(TrailzNetwork.readString(buf));
        this.trail = t;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        TrailzNetwork.writeString(buf, this.trail.getName());
        TrailzNetwork.writeString(buf, this.trail.getCreator());
        TrailzNetwork.writeString(buf, this.trail.getUUID());
        TrailzNetwork.writeString(buf, this.trail.getTexture());
    }
    
    public Trail getTrail() {
        return this.trail;
    }

}