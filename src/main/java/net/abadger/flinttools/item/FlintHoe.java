package net.abadger.flinttools.item;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

// Needed to create a subclass because the HoeItem constructor is protected...
public class FlintHoe extends HoeItem {
    public FlintHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
