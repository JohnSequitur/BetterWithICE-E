package jsequitur.icee.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;
import net.minecraft.core.block.*;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;
import static jsequitur.icee.IceeMod.MOD_ID;

public class IceeBlocks {
	private static int startingID = 6666;
	public static int newID(){
		return startingID++;
	}

	public static BlockBuilder genericBlockBuilder = new BlockBuilder(MOD_ID)
		.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS));
	public static Block<?> ICEE;
	public static Block<?> EGG_LEAVES;
	public static Block<?> EGG_LOG;
	public static Block<?> EGG_LOG_BASE;

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
			.build("icee.block", "icee_block", newID(), b-> new BlockLogicRotatable(b, Materials.CLOTH) {});
		EGG_LOG = genericBlockBuilder
			.setHardness(5f)
			.setBlockSound(BlockSounds.WOOD)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT)
			.build("egg.log", "egg_log", newID(), b-> new BlockLogic(b, Materials.WOOD) {});
		EGG_LOG_BASE = genericBlockBuilder
			.setHardness(5f)
			.setBlockSound(BlockSounds.WOOD)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT)
			.build("egg.log.base", "egg_log_base", newID(), b-> new BlockLogic(b, Materials.WOOD) {});
		EGG_LEAVES = genericBlockBuilder
			.setHardness(1f)
			.setBlockSound(BlockSounds.GRASS)
			.setTags(BlockTags.MINEABLE_BY_SHEARS)
			.build("egg.leaves", "egg_leaves", newID(), b-> new BlockLogic(b, Materials.LEAVES) {});
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
