package jsequitur.icee;

import jsequitur.icee.block.IceeBlocks;
import jsequitur.icee.items.IceeItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.ClientEvents;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.util.dependency.Key;

public class IceeMod implements ModInitializer {
	public static final String MOD_ID = HalpLibe.registerMod("icee", true);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static BlockBuilder genericBlockBuilder = new BlockBuilder(MOD_ID);
	public static Block<?> ICEE;


	@Override
	public void onInitialize() {
		CommonEvents.BEFORE_GAME_START.listen(Key.of(MOD_ID), this::beforeGameStart);
		CommonEvents.AFTER_GAME_START.listen(Key.of(MOD_ID), this::afterGameStart);
		LOGGER.info("Better With ICE-E! initialized.");
		CommonEvents.AFTER_BLOCK_INIT.listen(Key.of(MOD_ID), () -> new IceeBlocks().afterBlockInit());
		ClientEvents.BLOCK_MODEL_RELOAD.listen(Key.of(MOD_ID), Texturing::initBlockModels);
		CommonEvents.AFTER_ITEM_INIT.listen(Key.of(MOD_ID), () -> new IceeItems().afterItemInit());
		ClientEvents.ITEM_MODEL_RELOAD.listen(Key.of(MOD_ID), Texturing::initItemModels);
		CommonEvents.RECIPES_NAMESPACE_INIT.listen(Key.of(MOD_ID), () -> new IceeRecipeRegistry().initRecipes());


//		itemEssense = new ItemBuilder(MOD_ID).build(itemEssense);
//		ClientEvents.ITEM_MODEL_RELOAD.listen(Key.of(MOD_ID), Texturing::initItemModels);


	}

	public void beforeGameStart() {

	}

	public void afterGameStart() {

	}

}
