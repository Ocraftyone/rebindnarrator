package com.ocraftyone.rebindnarrator.mixin;

import com.ocraftyone.rebindnarrator.KeyBindHandler;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.input.KeyEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(KeyboardHandler.class)
public abstract class KeyboardHandlerMixinOld {
    @ModifyConstant(method = "keyPress", constant = @Constant(intValue = 66))
    private int getNarratorKey(int constant) {
        return KeyBindHandler.TOGGLE_NARRATOR.getKey().getValue();
    }

    @Redirect(method = "keyPress", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/input/KeyEvent;hasControlDown()Z", ordinal = 1))
    private boolean getModifierKey(KeyEvent instance) {
        if (KeyBindHandler.TOGGLE_NARRATOR.isUnbound()) {
            return false;
        }
        return KeyBindHandler.TOGGLE_NARRATOR.getKeyModifier().isActive(null);
    }
}
