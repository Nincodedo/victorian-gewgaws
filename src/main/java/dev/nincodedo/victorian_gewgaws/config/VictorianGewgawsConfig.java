package dev.nincodedo.victorian_gewgaws.config;

import dev.nincodedo.victorian_gewgaws.VictorianGewgaws;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = VictorianGewgaws.MOD_ID)
public class VictorianGewgawsConfig implements ConfigData {
    private final boolean nightVisionEnchantmentEnabled = true;
    private final boolean momentumEnchantmentEnabled = true;

    public boolean isMomentumEnchantmentEnabled() {
        return momentumEnchantmentEnabled;
    }

    public boolean isNightVisionEnchantmentEnabled() {
        return nightVisionEnchantmentEnabled;
    }
}
