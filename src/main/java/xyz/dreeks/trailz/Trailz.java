package xyz.dreeks.trailz;

import java.io.File;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.dreeks.trailz.events.TrailzEvents;
import xyz.dreeks.trailz.network.TrailzNetwork;
import xyz.dreeks.trailz.proxy.IProxy;
import xyz.dreeks.trailz.trails.Trail;
import xyz.dreeks.trailz.trails.TrailsLoader;
import xyz.dreeks.trailz.utils.Constants;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.MOD_VERSION)
public class Trailz 
{
    private static Logger logger;

    @SidedProxy(serverSide = Constants.SERVER_PROXY_LOCATION, clientSide = Constants.CLIENT_PROXY_LOCATION)
    public static IProxy proxy;

    @Mod.Instance
    public static Trailz instance;

    public static String TMP_SIDE;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        TMP_SIDE = event.getSide().toString();
        Constants.TRAILS_FOLDER = new File(event.getModConfigurationDirectory().getParent(), "/mods/trails_" + event.getSide());
        TrailsLoader.load();

        logger.info("Trails loaded: ");
        for (Trail t : Constants.TRAILS) {
            logger.info(t + " (created by " + t.getCreator() + ") UUID: " + t.getUUID());
        }

        TrailzEvents.register();
        TrailzNetwork.register();

        proxy.registerRenders();
        proxy.registerNetwork();
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {

    }
}
