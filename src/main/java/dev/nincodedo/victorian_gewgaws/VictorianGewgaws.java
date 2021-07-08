package dev.nincodedo.victorian_gewgaws;

import dev.nincodedo.victorian_gewgaws.enchantment.Enchantments;
import net.fabricmc.api.ModInitializer;

public class VictorianGewgaws implements ModInitializer {

    public static final String MOD_ID = "victorian-gewgaws";

    @Override
    public void onInitialize() {
        Enchantments.init();
    }
}
