package com.doublepi.taus_economy;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = TausEconomy.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.IntValue TOKENS_PER_TASK = BUILDER
            .comment("The number of tokens given to the player after completing a task:")
            .defineInRange("tokens_per_task",1,0,64);

    private static final ModConfigSpec.IntValue TOKENS_PER_GOAL = BUILDER
            .comment("The number of tokens given to the player after completing a goal:")
            .defineInRange("tokens_per_goal",3,0,64);

    private static final ModConfigSpec.IntValue TOKENS_PER_CHALLENGE = BUILDER
            .comment("The number of tokens given to the player after completing a challenge:")
            .defineInRange("tokens_per_challenge",5,0,64);

    public static final ModConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
            .comment("What you want the introduction message to be for the magic number")
            .define("magicNumberIntroduction", "The magic number is... ");


    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean logDirtBlock;
    public static int token_per_task;
    public static int token_per_goal;
    public static int token_per_challenge;
    public static Set<Item> items;

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        token_per_task = TOKENS_PER_TASK.get();
        token_per_goal = TOKENS_PER_GOAL.get();
        token_per_challenge = TOKENS_PER_CHALLENGE.get();

    }
}
