package jsequitur.icee;

import jsequitur.icee.block.IceeBlocks;
import jsequitur.icee.items.IceeItems;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;

public class IceeRecipeRegistry {

	public static final RecipeNamespace ICEE = new RecipeNamespace();

	public static void initRecipes() {
		RecipeBuilder.Shaped(IceeMod.MOD_ID)
			.setShape(
				"CCC",
				"CEC",
				"CCC")
			.addInput('C', Items.CLOTH)
			.addInput('E', IceeItems.ESSENCE)
			.create("ICE-E Block", new ItemStack(IceeBlocks.ICEE));
//		RecipeBuilder.Shaped(PotatoTech.MOD_ID)
//			.setShape(
//				"   ",
//				"IGI",
//				"   ")
//			.addInput('I', Item.ingotIron)
//			.addInput('G', Block.glass)
//			.create("Pipe", new ItemStack(PotatoTech.blockPipe, 8));
//
//		RecipeBuilder.Shaped(PotatoTech.MOD_ID)
//			.setShape(
//				" I ",
//				" II",
//				"I  "
//			)
//			.addInput('I', Item.ingotIron)
//			.create("Wrench", new ItemStack(PotatoTech.itemWrench));
//
//		RecipeBuilder.Shaped(PotatoTech.MOD_ID)
//			.setShape(
//				"IRI",
//				"RWR",
//				"IRI"
//			)
//			.addInput('I', Item.ingotIron)
//			.addInput('W', Block.workbench)
//			.addInput('R', Item.dustRedstone)
//			.create("Crafter", new ItemStack(PotatoTech.blockCrafter));
	}

	public static void InitNameSpaces() {
		// So, you can use this template to add more groups if needed.
		// Constant for a group of crafting recipes related to the workbench.
		final RecipeGroup<RecipeEntryCrafting<?, ?>> WORKBENCH =

			// Create a new RecipeGroup instance.
			new RecipeGroup<>(

				// Create a RecipeSymbol for the workbench.
				new RecipeSymbol(

					// ItemStack representing the workbench block.
					new ItemStack(Blocks.WORKBENCH)
				)
			);

		// Add the recipe group - id: yourGroupId
		ICEE.register("workbench", WORKBENCH);


		// If you have furnace recipes
		// final RecipeGroup<RecipeEntryFurnace> FURNACE = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Block.furnaceStoneActive)));
		// PARAGLIDER.register("furnace", FURNACE);

		// Register all
		Registries.RECIPES.register(IceeMod.MOD_ID, ICEE);

	}
}
