package net.abadger.flinttools.utils;

import net.abadger.flinttools.item.*;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemsInit {

    public static final Item
            WOODEN_CLUB,
            FLINT_AXE,
            FLINT_DAGGER,
            FLINT_HOE,
            FLINT_PICKAXE,
            FLINT_SHOVEL;

    private static void register(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier("flinttools", name), item);
    }

    public static void init() {
        register("wooden_club", WOODEN_CLUB);
        // flint
        register("flint_axe", FLINT_AXE);
        register("flint_dagger", FLINT_DAGGER);
        register("flint_hoe", FLINT_HOE);
        register("flint_pickaxe", FLINT_PICKAXE);
        register("flint_shovel", FLINT_SHOVEL);
    }

    static {
        WOODEN_CLUB = new SwordItem(
                ToolMaterials.WOOD,
                3,
                -3.0f,
                new Item.Settings().group(ModItemGroup.FLINTTOOLS)
        );
        FLINT_DAGGER = new SwordItem(
                new FlintToolMaterial(),
                1,
                -1.2f,
                new Item.Settings().group(ModItemGroup.FLINTTOOLS)
        );
        FLINT_SHOVEL = new ShovelItem(
                new FlintToolMaterial(),
                1.5f,
                -3.0f,
                new Item.Settings().group(ModItemGroup.FLINTTOOLS)
        );
        FLINT_PICKAXE = new PickaxeItem(
                new FlintToolMaterial(),
                1,
                -2.8f,
                new Item.Settings().group(ModItemGroup.FLINTTOOLS)
        );
        FLINT_AXE = new AxeItem(
                new FlintToolMaterial(),
                6.0f,
                -3.2f,
                new Item.Settings().group(ModItemGroup.FLINTTOOLS)
        );
        FLINT_HOE = new FlintHoe(
                new FlintToolMaterial(),
                0,
                -3.0f,
                new Item.Settings().group(ModItemGroup.FLINTTOOLS)
        );
    }

}

