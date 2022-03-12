package com.gotbot.worldmod.block;

import com.gotbot.worldmod.WorldMod;
import com.gotbot.worldmod.item.WorldModCreativeModeTabs;
import com.gotbot.worldmod.item.WorldModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class WorldModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WorldMod.MOD_ID);

    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    private static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> blockProp, CreativeModeTab tab)
    {
        RegistryObject<Block> block = BLOCKS.register(name, blockProp);
        WorldModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab).tab(WorldModCreativeModeTabs.WORLD_MOD)));
        return block;
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
