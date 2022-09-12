package com.teammoeg.frostedheart.compat.jei.extension;

import com.teammoeg.frostedheart.FHItems;
import com.teammoeg.frostedheart.content.recipes.RecipeModifyDamage;
import com.teammoeg.frostedheart.content.temperature.handstoves.CoalHandStove;
import com.teammoeg.frostedheart.content.temperature.handstoves.RecipeFueling;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.extensions.vanilla.crafting.ICraftingCategoryExtension;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;

public class DamageModifierExtension implements ICraftingCategoryExtension {
    RecipeModifyDamage fuel;

    public DamageModifierExtension(RecipeModifyDamage rf) {
        fuel = rf;
    }

    @Override
    public ResourceLocation getRegistryName() {
        return fuel.getId();
    }

    @Override
    public void setIngredients(IIngredients ingredients) {
    	ItemStack[] orig=fuel.tool.getMatchingStacks();
    	ItemStack[] copy=new ItemStack[orig.length];
    	ItemStack[] out=new ItemStack[orig.length];
    	for(int i=0;i<orig.length;i++) {
    		copy[i]=orig[i].copy();
    		out[i]=orig[i].copy();
    		if(fuel.modify>0) {
    			copy[i].setDamage(fuel.modify);
    			out[i].setDamage(0);
    		}else {
    			copy[i].setDamage(0);
    			out[i].setDamage(fuel.modify);
    		}
    	}
        ingredients.setInputLists(VanillaTypes.ITEM, Arrays.asList(Arrays.asList(copy), Arrays.asList(fuel.repair.getMatchingStacks())));
        ingredients.setOutputLists(VanillaTypes.ITEM, Arrays.asList(Arrays.asList(out)));
    }

}
