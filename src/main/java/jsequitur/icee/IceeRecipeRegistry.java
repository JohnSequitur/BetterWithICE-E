package jsequitur.icee;

import jsequitur.icee.block.IceeBlocks;
import jsequitur.icee.items.IceeItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryBlastFurnace;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryFurnace;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderFurnace;

import static jsequitur.icee.IceeMod.MOD_ID;

public class IceeRecipeRegistry {

	public static final RecipeNamespace ICEE = new RecipeNamespace();

	public static void initRecipes() {
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"CCC",
				"CEC",
				"CCC")
			.addInput('C', Items.CLOTH)
			.addInput('E', IceeItems.ESSENCE)
			.create("ICE-E Block", new ItemStack(IceeBlocks.ICEE));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(new ItemStack(IceeItems.PEZZA))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.create("P\"e\"zza with Ketchup", new ItemStack(IceeItems.PEZZA_KETCHUP_1, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(new ItemStack(IceeItems.PEZZA))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.create("P\"e\"zza with Ketchup", new ItemStack(IceeItems.PEZZA_KETCHUP_2, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(new ItemStack(IceeItems.PEZZA_KETCHUP_1))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.create("P\"e\"zza with Ketchup", new ItemStack(IceeItems.PEZZA_KETCHUP_2, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(new ItemStack(IceeItems.PEZZA))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.create("P\"e\"zza with Ketchup", new ItemStack(IceeItems.PEZZA_KETCHUP_3, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(new ItemStack(IceeItems.PEZZA_KETCHUP_1))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.create("P\"e\"zza with Ketchup", new ItemStack(IceeItems.PEZZA_KETCHUP_3, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(new ItemStack(IceeItems.PEZZA_KETCHUP_2))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.create("P\"e\"zza with Ketchup", new ItemStack(IceeItems.PEZZA_KETCHUP_3, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(new ItemStack(IceeItems.PEZZA))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.create("P\"e\"zza with Ketchup", new ItemStack(IceeItems.PEZZA_KETCHUP_4, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(new ItemStack(IceeItems.PEZZA_KETCHUP_1))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.create("P\"e\"zza with Ketchup", new ItemStack(IceeItems.PEZZA_KETCHUP_4, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(new ItemStack(IceeItems.PEZZA_KETCHUP_2))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.create("P\"e\"zza with Ketchup", new ItemStack(IceeItems.PEZZA_KETCHUP_4, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(new ItemStack(IceeItems.PEZZA_KETCHUP_3))
			.addInput(new ItemStack(IceeItems.KETCHUP))
			.create("P\"e\"zza with Ketchup", new ItemStack(IceeItems.PEZZA_KETCHUP_4, 1));
		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(IceeItems.LIGHTNER_SWORD_FROZEN)
			.create("Lightner Sword", IceeItems.LIGHTNER_SWORD);
		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(IceeItems.LIGHTNER_AXE_FROZEN)
			.create("Lightner Axe", IceeItems.LIGHTNER_AXE);
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

		final RecipeGroup<RecipeEntryBlastFurnace> BLAST_FURNACE = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Blocks.FURNACE_BLAST_ACTIVE)));
		ICEE.register("blast_furnace", BLAST_FURNACE);


		// Register all
		Registries.RECIPES.register(MOD_ID, ICEE);

	}
}
