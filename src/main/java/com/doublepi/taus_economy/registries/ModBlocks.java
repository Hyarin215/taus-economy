package com.doublepi.taus_economy.registries;

import com.doublepi.taus_economy.TausEconomy;
import com.doublepi.taus_economy.blocks.PlayerVaultBlock;
import com.doublepi.taus_economy.blocks.PlayerVaultBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.VaultBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    //Deferred Register
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TausEconomy.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TausEconomy.MOD_ID);

    //Player Vault
    public static final DeferredBlock<Block> PLAYER_VAULT = registerBlock("player_vault",
            ()-> new PlayerVaultBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                    .noOcclusion().sound(SoundType.VAULT).strength(50).lightLevel((blockState)->7)
                    .isViewBlocking(ModBlocks::never)));

    public static final Supplier<BlockEntityType<PlayerVaultBlockEntity>> PLAYER_VAULT_BE =
            BLOCK_ENTITIES.register("player_vault_be", () -> BlockEntityType.Builder.of(
                    PlayerVaultBlockEntity::new, ModBlocks.PLAYER_VAULT.get()).build(null));

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
        BLOCK_ENTITIES.register(eventBus);
    }
}


