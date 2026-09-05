package jsequitur.icee.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicSupplier;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;
import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Items;
import net.minecraft.core.sound.BlockSound;
import net.minecraft.core.sound.BlockSounds;
import net.minecraft.core.world.season.Seasons;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;
import jsequitur.icee.block.*;
import static jsequitur.icee.ExampleMod.MOD_ID;

public class IceeBlocks {
	private static int startingID = 6666;
	public static int newID(){
		return startingID++;
	}

	public static BlockBuilder genericBlockBuilder = new BlockBuilder(MOD_ID);
	public static Block<?> ICEE;
//	public static Block<?> MUSHROOM_CAP_RED;
//	public static Block<?> MUSHROOM_CAP_BROWN;
//	public static Block<?> MUSHROOM_STEM;

	private static boolean hasInit = false;
	public static void init(){
		if (!hasInit){
			hasInit = true;
			initializeBlocks();
		}
	}

	public static void initializeBlocks(){
//		BlockBuilder MushroomBlock = new BlockBuilder(MOD_ID)
//			.setBlockSound(BlockSounds.WOOD)
//			.setFlammability(0,0)
//			.setHardness(0.2f)
//			.setResistance(0.2f)
//			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ORGANIC))
//			.setTags(BlockTags.MINEABLE_BY_AXE,BlockTags.FENCES_CONNECT);


		ICEE = genericBlockBuilder
			.setHardness(1f)
			.setBlockSound(BlockSounds.CLOTH)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.PLACEABLES))
			.build("icee.block", "icee_block", newID(), b-> new BlockLogicRotatable(b, Materials.CLOTH) {});
//		MUSHROOM_CAP_RED = MushroomBlock
//			.build("mushroom.cap.red","mushroom_cap_red",newID(), f -> new BlockLogicMushroomBlockRed(f,Materials.WOOD));
//		MUSHROOM_CAP_BROWN = MushroomBlock
//			.build("mushroom.cap.brown","mushroom_cap_brown",newID(), f -> new BlockLogicMushroomBlockBrown(f,Materials.WOOD));
//		MUSHROOM_STEM = MushroomBlock
//			.build("mushroom.stem","mushroom_stem",newID(), f -> new BlockLogicMushroomStem(f,Materials.WOOD));
	}

	public void afterBlockInit() {
		initializeBlocks();
	}
}
