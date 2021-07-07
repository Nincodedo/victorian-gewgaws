package dev.nincodedo.enchantment;

import dev.nincodedo.VictorianGewgaws;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Enchantments {

    public static NightVisionEnchantment NIGHT_VISION;

    public static void init() {
        NIGHT_VISION = Registry
            .register(Registry.ENCHANTMENT, new Identifier(VictorianGewgaws.MOD_ID, "night_vision"),
                new NightVisionEnchantment());
    }
}
