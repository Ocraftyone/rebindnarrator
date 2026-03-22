package com.ocraftyone.rebindnarrator;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RebindNarrator.MODID)
public class RebindNarrator {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "rebindnarrator";

    public RebindNarrator() {
    }

    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public class ClientEvents {
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
        }

        @SubscribeEvent
        public static void registerKeybinds(RegisterKeyMappingsEvent event) {
            KeyBindHandler.registerKeybinds(event);
        }
    }
}
