package dev.nincodedo.victorian_gewgaws.data;

import net.minecraft.block.BlockState;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Optional;

public class DataTrackers {
    private static final TrackedData<Integer> BLOCKS_MINED = DataTracker.registerData(PlayerEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Optional<BlockState>> BLOCK_LAST_MINED = DataTracker.registerData(PlayerEntity.class,
        TrackedDataHandlerRegistry.OPTIONAL_BLOCK_STATE);

    public static TrackedData<Integer> getBlocksMined() {
        return BLOCKS_MINED;
    }

    public static TrackedData<Optional<BlockState>> getBlockLastMined() {
        return BLOCK_LAST_MINED;
    }
}
