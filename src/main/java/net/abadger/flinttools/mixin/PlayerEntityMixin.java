package net.abadger.flinttools.mixin;

import net.abadger.flinttools.FlintTools;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(
            method = "getBlockBreakingSpeed(Lnet/minecraft/block/BlockState;)F",
            at = @At("RETURN"),
            cancellable = true
    )
    private void breakingSpeed(BlockState block, CallbackInfoReturnable<Float> cir) {
        ItemStack itemStack = this.getMainHandStack();
        StatusEffectInstance strengthEffect = this.getStatusEffect(StatusEffects.STRENGTH);
        int strengthPower = -1;
        if (strengthEffect != null)
            strengthPower = strengthEffect.getAmplifier();
        float hardness = block.getBlock().getHardness();
        float baseBreakSpeed = 1.0f;
        if (hardness >= 0.5f)
            baseBreakSpeed = 0.1f;
        if (hardness >= 1.0f)
            baseBreakSpeed = 0.0f;
        if (itemStack.getMiningSpeedMultiplier(block) == 1.0F) {
            cir.setReturnValue(cir.getReturnValue() * baseBreakSpeed + 0.75F * (strengthPower + 1));
        }
    }
}
