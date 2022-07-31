package com.ocraftyone.rebindnarrator;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public final class KeyBindHandler {
    public static final KeyBinding TOGGLE_NARRATOR = new KeyBinding("key.rebindnarrator.togglenarrator", KeyConflictContext.UNIVERSAL, KeyModifier.CONTROL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_B, "key.categories.misc");
    
    public static void registerKeybinds() {
        ClientRegistry.registerKeyBinding(TOGGLE_NARRATOR);
    }
}
