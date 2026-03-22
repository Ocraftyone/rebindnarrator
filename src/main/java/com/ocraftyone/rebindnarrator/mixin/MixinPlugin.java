package com.ocraftyone.rebindnarrator.mixin;

import net.neoforged.fml.loading.FMLLoader;
import org.apache.logging.log4j.LogManager;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MixinPlugin implements IMixinConfigPlugin {
    private boolean use_new_mixin =  false;
    @Override
    public void onLoad(String mixinPackage) {
        var mc_version = Runtime.Version.parse(FMLLoader.getCurrent().getVersionInfo().mcVersion());
        use_new_mixin = mc_version.update() > 10;
        LogManager.getLogger().info("Use new mixin: {}, Version: {}", use_new_mixin, mc_version.update());
    }

    @Override
    public String getRefMapperConfig() {
        return "";
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.equals("com.ocraftyone.rebindnarrator.mixin.KeyboardHandlerMixin")) {
            return use_new_mixin;
        }
        if (mixinClassName.equals("com.ocraftyone.rebindnarrator.mixin.KeyboardHandlerMixinOld")){
            return !use_new_mixin;
        }
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return List.of();
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
