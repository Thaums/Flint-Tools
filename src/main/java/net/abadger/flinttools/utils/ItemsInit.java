package net.abadger.flinttools.utils;

import net.abadger.flinttools.FlintTools;
import net.abadger.flinttools.item.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemsInit {

    public static final Item
            WOODEN_CLUB,
            FLINT_AXE,
            FLINT_DAGGER,
            FLINT_HOE,
            FLINT_PICKAXE,
            FLINT_SHOVEL;

    private static Item register(String name, Item item) {
        Identifier itemID = Identifier.of(FlintTools.MOD_ID, name);
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        return registeredItem;
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
                new Item.Settings()
        );
        FLINT_DAGGER = new SwordItem(
                new FlintToolMaterial(),
                1,
                -1.2f,
                new Item.Settings()
        );
        FLINT_SHOVEL = new ShovelItem(
                new FlintToolMaterial(),
                1.5f,
                -3.0f,
                new Item.Settings()
        );
        FLINT_PICKAXE = new PickaxeItem(
                new FlintToolMaterial(),
                1,
                -2.8f,
                new Item.Settings()
        );
        FLINT_AXE = new AxeItem(
                new FlintToolMaterial(),
                6.0f,
                -3.2f,
                new Item.Settings()
        );
        FLINT_HOE = new FlintHoe(
                new FlintToolMaterial(),
                0,
                -3.0f,
                new Item.Settings()
        );
        Registry.register(Registries.ITEM_GROUP, ModItemGroup.FLINTTOOLS_GROUP_KEY, ModItemGroup.FLINTTOOLS);
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.FLINTTOOLS_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(WOODEN_CLUB);
            itemGroup.add(FLINT_DAGGER);
            itemGroup.add(FLINT_SHOVEL);
            itemGroup.add(FLINT_PICKAXE);
            itemGroup.add(FLINT_AXE);
            itemGroup.add(FLINT_HOE);
        });
    }

}

