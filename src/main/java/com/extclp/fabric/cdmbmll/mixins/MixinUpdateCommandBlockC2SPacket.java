package com.extclp.fabric.cdmbmll.mixins;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.UpdateCommandBlockC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(UpdateCommandBlockC2SPacket.class)
public class MixinUpdateCommandBlockC2SPacket {

    @Redirect(method = "<init>(Lnet/minecraft/network/PacketByteBuf;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/PacketByteBuf;readString()Ljava/lang/String;"))
    public String changeReadLengthLimit(PacketByteBuf buf){
        return buf.readString(Integer.MAX_VALUE / 4);
    }

    @Redirect(method = "write", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/PacketByteBuf;writeString(Ljava/lang/String;)Lnet/minecraft/network/PacketByteBuf;"))
    public PacketByteBuf changeWriteLengthLimit(PacketByteBuf buf, String command){
        return buf.writeString(command, Integer.MAX_VALUE / 4);
    }
}
