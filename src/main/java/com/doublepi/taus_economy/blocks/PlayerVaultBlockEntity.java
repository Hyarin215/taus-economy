package com.doublepi.taus_economy.blocks;

import com.doublepi.taus_economy.registries.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PlayerVaultBlockEntity extends BlockEntity {
    public PlayerVaultBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlocks.PLAYER_VAULT_BE.get(), pos, blockState);
    }


}
