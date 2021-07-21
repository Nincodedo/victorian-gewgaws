package dev.nincodedo.victorian_gewgaws;

import dev.nincodedo.victorian_gewgaws.config.VictorianGewgawsConfig;
import dev.nincodedo.victorian_gewgaws.enchantment.Enchantments;
import dev.nincodedo.victorian_gewgaws.events.Events;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class VictorianGewgaws implements ModInitializer {

    public static final String MOD_ID = "victorian-gewgaws";

    @Override
    public void onInitialize() {
        AutoConfig.register(VictorianGewgawsConfig.class, GsonConfigSerializer::new);
        Enchantments.init();
        Events.init();
    }
}
