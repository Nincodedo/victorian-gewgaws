package dev.nincodedo.victorian_gewgaws.mixin;

import dev.nincodedo.victorian_gewgaws.data.DataTrackers;
import dev.nincodedo.victorian_gewgaws.enchantment.Enchantments;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    PlayerEntity playerEntity = (PlayerEntity) (Object) this;

    @Inject(method = "getBlockBreakingSpeed(Lnet/minecraft/block/BlockState;)F", at = @At("TAIL"), cancellable = true)
    private void inject(BlockState block, CallbackInfoReturnable<Float> cir) {
        if (playerEntity.getDataTracker().getAllEntries().stream().noneMatch(entry -> DataTrackers.getBlockLastMined().equals(entry.getData())) || playerEntity.getDataTracker().getAllEntries().stream().noneMatch(entry -> DataTrackers.getBlocksMined().equals(entry.getData()))) {
            return;
        }
        Optional<BlockState> optionalBlockState = playerEntity.getDataTracker().get(DataTrackers.getBlockLastMined());
        if (optionalBlockState.isPresent()) {
            BlockState lastBlockMined = optionalBlockState.get();
            int blocksMined = playerEntity.getDataTracker().get(DataTrackers.getBlocksMined());
            if (EnchantmentHelper.getEquipmentLevel(Enchantments.MOMENTUM, playerEntity) > 0) {
                if (block.getBlock().getName().equals(lastBlockMined.getBlock().getName())) {
                    float originalSpeed = cir.getReturnValue();
                    float newSpeed = (float) (originalSpeed * 1.1 * (blocksMined + 1));
                    cir.setReturnValue(newSpeed);
                }
            }
        }
    }
}
