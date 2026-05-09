package com.chinaex123.create_more_catalysts.compat.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.ConduitBlockEntity;

/**
 * 潮涌核心动画渲染器：用于在JEI中显示激活的潮涌核心
 */
public class AnimatedConduit extends AnimatedKinetics {

    /**
     * 获取潮涌核心X轴旋转角度
     * @return X轴旋转角度
     */
    private static float getConduitAngle(boolean xAxis) {
        if (xAxis) {
            return 30 * (Mth.sin(((AnimationTickHolder.getRenderTime() * 2f) % 360) * (float) Math.PI / 180));
        } else {
            return (AnimationTickHolder.getRenderTime() * 2f) % 360;
        }
    }

    /**
     * 获取潮涌核心高度偏移
     * @return 高度偏移值
     */
    private static float getConduitHeight() {
        return (0.2f * (Mth.sin(((AnimationTickHolder.getRenderTime() * 4f) % 360) * (float) Math.PI / 180)));
    }

    /**
     * 在指定位置绘制潮涌核心
     * @param graphics GUI图形上下文
     * @param xOffset X轴偏移
     * @param yOffset Y轴偏移
     */
    @Override
    public void draw(GuiGraphics graphics, int xOffset, int yOffset) {
        PoseStack matrixStack = graphics.pose();
        matrixStack.pushPose();
        matrixStack.translate(xOffset, yOffset, 0);

        GuiGameElement.of(new ConduitBlockEntity(BlockPos.ZERO, Blocks.CONDUIT.defaultBlockState()))
                .atLocal(0, getConduitHeight(), 2)
                .rotateBlock(getConduitAngle(true), getConduitAngle(false), 0)
                .scale(24)
                .lighting(DEFAULT_LIGHTING)
                .render(graphics);

        matrixStack.popPose();
    }
}