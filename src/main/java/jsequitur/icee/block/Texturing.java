package jsequitur.icee.block;

import jsequitur.icee.items.IceeItems;
import net.minecraft.client.render.EntityRendererDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.*;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.core.util.helper.Side;


public class Texturing {
	public static void initBlockModels(BlockModelDispatcher dispatcher) {
		BlockModelHorizontalRotation<?> iceeModel = new BlockModelHorizontalRotation<>(IceeBlocks.ICEE);
		dispatcher.addDispatch(iceeModel
			.setTex("icee:block/icee_block", Side.TOP)
			.setTex("icee:block/icee_block", Side.BOTTOM)
			.setTex("icee:block/icee_block_back", Side.SOUTH)
			.setTex("icee:block/icee_block_front", Side.NORTH)
			.setTex("icee:block/icee_block_left", Side.WEST)
			.setTex("icee:block/icee_block_right", Side.EAST));
	}

	public static void initItemModels(ItemModelDispatcher dispatcher) {
		ItemModelStandard essenceModel = new ItemModelStandard(IceeItems.ESSENCE);
		dispatcher.addDispatch(essenceModel
			.setIcon("icee:item/essence"));
	}

	public void initEntityModels(EntityRendererDispatcher dispatcher) {

	}

	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}


}
