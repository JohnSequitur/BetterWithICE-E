package jsequitur.icee.block;

import net.minecraft.client.render.EntityRendererDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.*;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.helper.Sides;


public class Texturing {
	public static void initBlockModels(BlockModelDispatcher dispatcher) {
		BlockModelRotatable<?> iceeModel = new BlockModelRotatable(IceeBlocks.ICEE);
		dispatcher.addDispatch(iceeModel
			.setTex("icee:block/icee_block_front", Side.TOP)
			.setTex("icee:block/icee_block_back", Side.BOTTOM)
			.setTex("icee:block/icee_block", Side.SOUTH)
			.setTex("icee:block/icee_block", Side.NORTH)
			.setTex("icee:block/icee_block_left", Side.WEST)
			.setTex("icee:block/icee_block_right", Side.EAST));
//		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.MUSHROOM_CAP_RED)
//			.setTex("betterwithbigshrooms:block/mushroom_block_red", Side.sides)
//			.setTex("betterwithbigshrooms:block/mushroom_block_red", Side.TOP)
//			.setTex("betterwithbigshrooms:block/mushroom_pores", Side.BOTTOM));
//		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.MUSHROOM_CAP_BROWN)
//			.setTex("betterwithbigshrooms:block/mushroom_block_brown", Side.sides)
//			.setTex("betterwithbigshrooms:block/mushroom_block_brown", Side.TOP)
//			.setTex("betterwithbigshrooms:block/mushroom_pores", Side.BOTTOM));
//		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.MUSHROOM_STEM)
//			.setTex("betterwithbigshrooms:block/mushroom_stem", Side.sides)
//			.setTex("betterwithbigshrooms:block/mushroom_pores", Side.TOP, Side.BOTTOM));
	}

	public void initItemModels(ItemModelDispatcher dispatcher) {

	}

	public void initEntityModels(EntityRendererDispatcher dispatcher) {

	}

	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}


}
