package dev.nincodedo.victorian_gewgaws.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;

public class NightVisionEnchantment extends Enchantment {

    public NightVisionEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD});
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !Enchantments.RESPIRATION.equals(other)
            && !Enchantments.AQUA_AFFINITY.equals(other);
    }

    @Override
    public boolean isTreasure() {
        return true;
    }
}
