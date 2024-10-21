package net.abadger.flinttools.utils;


import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class ModItemTags {
    public static final TagKey<Item> WOODEN_TOOLS = register("wooden_tools");
    public static final TagKey<Item> STONE_TOOLS = register("stone_tools");
    public static final TagKey<Item> IRON_TOOLS = register("iron_tools");
    public static final TagKey<Item> GOLD_TOOLS = register("gold_tools");
    public static final TagKey<Item> DIAMOND_TOOLS = register("diamond_tools");

    //public static final TagKey<Item> AXES = register("axes");
    //public static final TagKey<Item> SAWS = register("saws");
    //public static final TagKey<Item> KNIVES = register("knives");

    private ModItemTags() { }

    private static TagKey<Item> register(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier("flinttools", id));
    }
}

