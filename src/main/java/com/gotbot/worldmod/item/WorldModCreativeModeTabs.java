package com.gotbot.worldmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class WorldModCreativeModeTabs {
    public static final CreativeModeTab WORLD_MOD = new CreativeModeTab("worldmodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(WorldModItems.SILVER_INGOT.get());
        }
    };
}
