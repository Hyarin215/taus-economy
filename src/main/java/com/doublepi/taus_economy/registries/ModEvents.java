package com.doublepi.taus_economy.registries;

import com.doublepi.taus_economy.Config;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.AdvancementEvent;

public class ModEvents {

    public static void register(){
        NeoForge.EVENT_BUS.addListener(ModEvents::giveToken);
    }

    private static void giveToken(AdvancementEvent.AdvancementEarnEvent event){
        Advancement advancement = event.getAdvancement().value();
        Player player = event.getEntity();
        AdvancementType type = advancement.display().get().getType();

        if(type == AdvancementType.TASK)
            player.addItem(new ItemStack(ModItems.TOKEN.get(), Config.token_per_task));
        if(type == AdvancementType.GOAL)
            player.addItem(new ItemStack(ModItems.TOKEN.get(),Config.token_per_goal));
        if(type == AdvancementType.CHALLENGE)
            player.addItem(new ItemStack(ModItems.TOKEN.get(),Config.token_per_challenge));
    }
}
