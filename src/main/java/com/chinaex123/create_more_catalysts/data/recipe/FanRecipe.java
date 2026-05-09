package com.chinaex123.create_more_catalysts.data.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class FanRecipe extends ProcessingRecipe<Container> {

    private final IRecipeTypeInfo typeInfo;

    public FanRecipe(IRecipeTypeInfo typeInfo, ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(typeInfo, params);
        this.typeInfo = typeInfo;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return typeInfo.getSerializer();
    }

    @Override
    public boolean matches(Container container, Level level) {
        if (container.isEmpty()) {
            return false;
        }
        return !this.ingredients.isEmpty() && this.ingredients.get(0).test(container.getItem(0));
    }

    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    @Override
    protected int getMaxOutputCount() {
        return 12;
    }
}
