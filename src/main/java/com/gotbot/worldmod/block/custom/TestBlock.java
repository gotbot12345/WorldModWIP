package com.gotbot.worldmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Column;

public class TestBlock extends Block {
    public TestBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (pEntity instanceof LivingEntity)
        {
            LivingEntity entity = ((LivingEntity) pEntity);
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400));
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
