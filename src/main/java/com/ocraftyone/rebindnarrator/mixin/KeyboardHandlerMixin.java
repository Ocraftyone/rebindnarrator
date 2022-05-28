package com.ocraftyone.rebindnarrator.mixin;

import com.ocraftyone.rebindnarrator.KeyBindHandler;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.NarratorStatus;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.SimpleOptionsSubScreen;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(KeyboardHandler.class)
public abstract class KeyboardHandlerMixin {
/*    @Final
    @Shadow
    private Minecraft minecraft;
    
    @Inject(method = "keyPress", at = @At(
            value = "INVOKE",
            shift = At.Shift.BEFORE,
            target = "Lnet/minecraft/client/gui/screens/Screen;hasControlDown()Z",
            ordinal = 1
    ), locals = LocalCapture.CAPTURE_FAILHARD)
    private void onKeyPress(long pWindowPointer, int pKey, int pScanCode, int pAction, int pModifiers, CallbackInfo ci, Screen screen) {
        KeyMapping toggleNarrator = KeyBindHandler.TOGGLE_NARRATOR;
        boolean flag = screen == null || !(screen.getFocused() instanceof EditBox) || !((EditBox) screen.getFocused()).canConsumeInput();
        if (pAction != GLFW.GLFW_RELEASE && flag && toggleNarrator.matches(pKey, pScanCode)) {
            boolean flag1 = this.minecraft.options.narratorStatus == NarratorStatus.OFF;
            this.minecraft.options.narratorStatus = NarratorStatus.byId(this.minecraft.options.narratorStatus.getId() + 1);
            NarratorChatListener.INSTANCE.updateNarratorStatus(this.minecraft.options.narratorStatus);
            if (screen instanceof SimpleOptionsSubScreen) {
                ((SimpleOptionsSubScreen) screen).updateNarratorButton();
            }
            
            if (flag1 && screen != null) {
                screen.narrationEnabled();
            }
        }
    }
    
    @ModifyVariable(method = "keyPress", at = @At("STORE"), ordinal = 0)
    private boolean modifyFlag(boolean flag) {
        return false;
    }*/
    
    @ModifyConstant(method = "keyPress", constant = @Constant(intValue = 66))
    private int getNarratorKey(int constant) {
        return KeyBindHandler.TOGGLE_NARRATOR.getKey().getValue();
    }

    @Redirect(method = "keyPress", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/Screen;hasControlDown()Z", ordinal = 1))
    private boolean getModifierKey() {
        return KeyBindHandler.TOGGLE_NARRATOR.getKeyModifier().isActive(null);
    }
}
