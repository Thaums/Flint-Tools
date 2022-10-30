package net.abadger.flinttools.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup FLINTTOOLS = FabricItemGroupBuilder.build(
            new Identifier("flinttools", "eggroup"),
            () -> new ItemStack(Items.FLINT));
}

