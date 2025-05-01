package com.ruprous.stonecobbler;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class RPStoneCobbler implements ModInitializer {

    public static final String MOD_ID = "stonecobbler";
    public static Item PEBBLE;

    @Override
    public void onInitialize() {
        Identifier id = Identifier.of(MOD_ID, "pebble");
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Settings settings = new Item.Settings().registryKey(key);
        PEBBLE = Registry.register(Registries.ITEM, key, new Item(settings));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
        entries.add(PEBBLE);
    });
    }
}
