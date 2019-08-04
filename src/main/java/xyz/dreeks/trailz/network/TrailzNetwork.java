package xyz.dreeks.trailz.network;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import xyz.dreeks.trailz.utils.Constants;

public class TrailzNetwork {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Constants.MOD_ID);
    private static int DISCRIMINATOR = 0;

    public static void register() {
        INSTANCE.registerMessage(HandlerUploadTrails.class, PacketUploadTrails.class, DISCRIMINATOR++, Side.SERVER);
    }

    public static void writeString(ByteBuf buf, String str) {
        buf.writeInt(str.length());
        buf.writeCharSequence(str, Charset.forName("utf-8"));
    }

    public static String readString(ByteBuf buf, int maxSize) {
        int l = buf.readInt();
        if (l > maxSize) l = maxSize;
        return buf.readCharSequence(l, Charset.forName("utf-8")).toString();
    }

}