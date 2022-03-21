package com.gotbot.worldmod.item;

import com.gotbot.worldmod.WorldMod;
import com.gotbot.worldmod.item.custom.TestItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// test test
public class WorldModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WorldMod.MOD_ID);

    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).tab(WorldModCreativeModeTabs.WORLD_MOD)));

    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).tab(WorldModCreativeModeTabs.WORLD_MOD)));

    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).tab(WorldModCreativeModeTabs.WORLD_MOD)));

    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", () -> new TestItem(new Item.Properties().tab(WorldModCreativeModeTabs.WORLD_MOD_TESTING)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
