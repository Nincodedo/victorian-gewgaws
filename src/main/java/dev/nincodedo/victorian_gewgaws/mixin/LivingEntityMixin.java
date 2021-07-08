package dev.nincodedo.victorian_gewgaws.mixin;

import dev.nincodedo.victorian_gewgaws.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    LivingEntity livingEntity = (LivingEntity) (Object) this;

    @Inject(method = "baseTick",
        at = @At("RETURN"),
        cancellable = true)
    public void injectBaseTick(CallbackInfo callbackInfo) {
        int nightVisionLevel = EnchantmentHelper.getEquipmentLevel(Enchantments.NIGHT_VISION, livingEntity);
        if (nightVisionLevel == 1) {
            Integer currentDuration = null;
            if (livingEntity.hasStatusEffect(StatusEffects.NIGHT_VISION)) {
                currentDuration = livingEntity.getStatusEffect(StatusEffects.NIGHT_VISION).getDuration();
            }
            if (currentDuration != null && currentDuration < 201 || !livingEntity
                .hasStatusEffect(StatusEffects.NIGHT_VISION)) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 30 * 20, 0, false,
                    false));
            }
        }
    }
}
