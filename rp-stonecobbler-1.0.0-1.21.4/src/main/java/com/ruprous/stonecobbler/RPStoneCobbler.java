package com.ruprous.stonecobbler;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class RPStoneCobbler implements ModInitializer {

    public static final String MOD_ID = "stonecobbler";
    public static final Item PEBBLE = register("pebble", Item::new, new Item.Settings());

    @Override
    public void onInitialize() {
    }

    private static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(MOD_ID, path);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        settings.registryKey(key);
        return Registry.register(Registries.ITEM, key, factory.apply(settings));
    }
}
