package com.ocraftyone.rebindnarrator;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fmlclient.registry.ClientRegistry;

public final class KeyBindHandler {
    public static final KeyMapping TOGGLE_NARRATOR = new KeyMapping("key.rebindnarrator.togglenarrator", KeyConflictContext.UNIVERSAL, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, InputConstants.KEY_B, KeyMapping.CATEGORY_MISC);
    
    public static void registerKeybinds() {
        ClientRegistry.registerKeyBinding(TOGGLE_NARRATOR);
    }
}
