package dev.nincodedo.victorian_gewgaws.enchantment;

import dev.nincodedo.victorian_gewgaws.VictorianGewgaws;
import dev.nincodedo.victorian_gewgaws.config.VictorianGewgawsConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Enchantments {

    public static NightVisionEnchantment NIGHT_VISION = new NightVisionEnchantment();
    public static MomentumEnchantment MOMENTUM = new MomentumEnchantment();

    public static void init() {
        VictorianGewgawsConfig config = AutoConfig.getConfigHolder(VictorianGewgawsConfig.class).getConfig();
        if (config.isNightVisionEnchantmentEnabled()) {
            NIGHT_VISION = Registry
                .register(Registry.ENCHANTMENT, new Identifier(VictorianGewgaws.MOD_ID, "night_vision"),
                    new NightVisionEnchantment());
        }
        if (config.isMomentumEnchantmentEnabled()) {
            MOMENTUM = Registry.register(Registry.ENCHANTMENT, new Identifier(VictorianGewgaws.MOD_ID, "momentum"),
                new MomentumEnchantment());
        }
    }
}
