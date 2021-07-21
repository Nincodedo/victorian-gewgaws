package dev.nincodedo.victorian_gewgaws.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;

public class MomentumEnchantment extends Enchantment {
    public MomentumEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !Enchantments.EFFICIENCY.equals(other) && super.canAccept(other);
    }

    @Override
    public boolean isTreasure() {
        return true;
    }
}
