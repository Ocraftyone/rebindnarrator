package com.ocraftyone.rebindnarrator;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.client.settings.KeyModifier;

public final class KeyBindHandler {
    public static final KeyMapping TOGGLE_NARRATOR = new KeyMapping("key.rebindnarrator.togglenarrator", KeyConflictContext.UNIVERSAL, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, InputConstants.KEY_B, KeyMapping.Category.MISC);
    
    public static void registerKeybinds(RegisterKeyMappingsEvent event) {
        event.register(TOGGLE_NARRATOR);
    }
}
