package xyz.dreeks.trailz.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import xyz.dreeks.trailz.trails.Trail;

public class PacketUploadTrails implements IMessage {

    private Trail trail;

    public PacketUploadTrails(Trail t) {
        this.trail = t;
    }

    /** Forced by MC/Forge so keep it there */
    public PacketUploadTrails() {}

    @Override
    public void fromBytes(ByteBuf buf) {
        Trail t = new Trail();
        t.setName(TrailzNetwork.readString(buf, 20));
        t.setCreator(TrailzNetwork.readString(buf, 20));
        t.setUUID(TrailzNetwork.readString(buf, 36));
        t.setTexture(TrailzNetwork.readString(buf, 200)); // @TODO: Find a max size for the choosed png dim
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