package com.gotbot.worldmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class TestItem  extends Item {

    public TestItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos blockPos = pContext.getClickedPos();
        Player player = pContext.getPlayer();

        if (player.isCreative())
        {
            Block block = pContext.getLevel().getBlockState(blockPos).getBlock();

            if (block == Blocks.DIAMOND_BLOCK)
            {
                player.sendMessage(new TextComponent("Diamond!!!"), player.getUUID());
            }
            else
            {
                player.sendMessage(new TextComponent("No Diamond :("), player.getUUID());
            }
        }

        return super.useOn(pContext);
    }
}
