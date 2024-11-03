package com.doublepi.taus_economy.registries;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class ModTabs {


    public static void addToExistingTabs(BuildCreativeModeTabContentsEvent event){
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS)
            event.accept(ModBlocks.PLAYER_VAULT);
        if  (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
            event.accept(ModItems.TOKEN);
    }
}
