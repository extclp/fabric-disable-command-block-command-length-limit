package com.extclp.fabric.cdmbmll.mixins;

import net.minecraft.client.gui.screen.ingame.AbstractCommandBlockScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(AbstractCommandBlockScreen.class)
public class MixinAbstractCommandBlockScreen {

    @ModifyConstant(method = "init", constant = @Constant(intValue = 32500, ordinal=0))
    private int disableCommandBlockCommandLengthLimit(int origin){
        return Integer.MAX_VALUE;
    }
}
