package dev.nincodedo.victorian_gewgaws.events;

import dev.nincodedo.victorian_gewgaws.data.DataTrackers;
import dev.nincodedo.victorian_gewgaws.enchantment.Enchantments;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

public class Events {
    public static void init() {
        PlayerBlockBreakEvents.AFTER.register(Events::afterBlockBreak);
    }

    private static void afterBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        if (EnchantmentHelper.getEquipmentLevel(Enchantments.MOMENTUM, player) > 0) {
            if (player.getDataTracker().getAllEntries().stream().noneMatch(entry -> DataTrackers.getBlockLastMined().equals(entry.getData()))) {
                player.getDataTracker().startTracking(DataTrackers.getBlockLastMined(),
                    Optional.of(Blocks.AIR.getDefaultState()));
            }
            if (player.getDataTracker().getAllEntries().stream().noneMatch(entry -> DataTrackers.getBlocksMined().equals(entry.getData()))) {
                player.getDataTracker().startTracking(DataTrackers.getBlocksMined(), 0);
            }

            Optional<BlockState> optionalLastBlockState =
                player.getDataTracker().get(DataTrackers.getBlockLastMined());
            if (optionalLastBlockState.isPresent() && optionalLastBlockState.get().getBlock().equals(state.getBlock())) {
                player.getDataTracker().set(DataTrackers.getBlocksMined(),
                    player.getDataTracker().get(DataTrackers.getBlocksMined()) + 1);
            } else {
                player.getDataTracker().set(DataTrackers.getBlocksMined(), 0);
            }
            player.getDataTracker().set(DataTrackers.getBlockLastMined(), Optional.of(state));
        }
    }
}
