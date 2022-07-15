package com.ocraftyone.rebindnarrator.mixin;

import com.ocraftyone.rebindnarrator.KeyBindHandler;
import net.minecraft.client.KeyboardHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(KeyboardHandler.class)
public abstract class KeyboardHandlerMixin {
    @ModifyConstant(method = "keyPress", constant = @Constant(intValue = 66))
    private int getNarratorKey(int constant) {
        return KeyBindHandler.TOGGLE_NARRATOR.getKey().getValue();
    }

    @Redirect(method = "keyPress", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/Screen;hasControlDown()Z", ordinal = 1))
    private boolean getModifierKey() {
        if (KeyBindHandler.TOGGLE_NARRATOR.isUnbound()) {
            return false;
        }
        return KeyBindHandler.TOGGLE_NARRATOR.getKeyModifier().isActive(null);
    }
}
