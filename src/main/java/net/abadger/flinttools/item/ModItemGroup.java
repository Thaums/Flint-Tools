package net.abadger.flinttools.item;

import net.abadger.flinttools.FlintTools;
import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final RegistryKey<ItemGroup> FLINTTOOLS_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(FlintTools.MOD_ID, "item_group"));
    public static final ItemGroup FLINTTOOLS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.FLINT))
            .displayName(Text.translatable("itemGroup.earlygame.eggroup"))
            .build();
    //public static final ItemGroup FLINTTOOLS = FabricItemGroupBuilder.build(
    //        new Identifier("flinttools", "eggroup"),
    //        () -> new ItemStack(Items.FLINT));
}

