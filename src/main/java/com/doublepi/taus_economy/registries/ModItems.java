package com.doublepi.taus_economy.registries;

import com.doublepi.taus_economy.TausEconomy;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TausEconomy.MOD_ID);

    public static final DeferredItem<Item> TOKEN = ITEMS.register("token",
            ()-> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
