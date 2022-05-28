package com.ocraftyone.rebindnarrator;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;

public final class KeyBindHandler {
    public static final KeyMapping TOGGLE_NARRATOR = new KeyMapping("key.rebindnarrator.togglenarrator", KeyConflictContext.UNIVERSAL, KeyModifier.CONTROL, InputConstants.Type.KEYSYM, InputConstants.KEY_B, KeyMapping.CATEGORY_MISC);
    
    public static void registerKeybinds() {
        ClientRegistry.registerKeyBinding(TOGGLE_NARRATOR);
    }
}
