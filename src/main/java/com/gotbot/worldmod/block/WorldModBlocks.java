package com.gotbot.worldmod.block;

import com.gotbot.worldmod.WorldMod;
import com.gotbot.worldmod.block.custom.TestBlock;
import com.gotbot.worldmod.item.WorldModCreativeModeTabs;
import com.gotbot.worldmod.item.WorldModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class WorldModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WorldMod.MOD_ID);

    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> TEST_BLOCK = registerTestBlock("test_block", () -> new TestBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> blockProp, CreativeModeTab tab)
    {
        RegistryObject<Block> block = BLOCKS.register(name, blockProp);
        WorldModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab).tab(WorldModCreativeModeTabs.WORLD_MOD)));
        return block;
    }

    private static <T extends Block> RegistryObject<Block> registerBlockNoTab(String name, Supplier<T> blockProp)
    {
        RegistryObject<Block> block = BLOCKS.register(name, blockProp);
        WorldModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(WorldModCreativeModeTabs.WORLD_MOD)));
        return block;
    }

    private static <T extends Block> RegistryObject<Block> registerTestBlock(String name, Supplier<T> blockProp)
    {
        RegistryObject<Block> block = BLOCKS.register(name, blockProp);
        WorldModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(WorldModCreativeModeTabs.WORLD_MOD_TESTING)));
        return block;
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
