package jsequitur.icee;

import jsequitur.icee.block.IceeBlocks;
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
			.setTex("icee:block/icee_block_blank", Side.TOP)
			.setTex("icee:block/icee_block_blank", Side.BOTTOM)
			.setTex("icee:block/icee_block_blank", Side.SOUTH)
			.setTex("icee:block/icee_block_front", Side.NORTH)
			.setTex("icee:block/icee_block_sweaty", Side.WEST)
			.setTex("icee:block/icee_block_very_sweaty", Side.EAST));
	}

	public static void initItemModels(ItemModelDispatcher dispatcher) {
		ItemModelStandard essenceModel = new ItemModelStandard(IceeItems.ESSENCE);
		dispatcher.addDispatch(essenceModel
			.setIcon("icee:item/essence"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.PEZZA)
			.setIcon("icee:item/pezza"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.PEZZA_KETCHUP_1)
			.setIcon("icee:item/pezza_ketchup_1"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.PEZZA_KETCHUP_2)
			.setIcon("icee:item/pezza_ketchup_2"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.PEZZA_KETCHUP_3)
			.setIcon("icee:item/pezza_ketchup_3"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.PEZZA_KETCHUP_4)
			.setIcon("icee:item/pezza_ketchup_4"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.PEZZA_FROZEN)
			.setIcon("icee:item/pezza_frozen"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.KETCHUP)
			.setIcon("icee:item/ketchup"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.LIGHTNER_SWORD)
			.setIcon("icee:item/lightner_sword"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.LIGHTNER_SWORD_FROZEN)
			.setIcon("icee:item/lightner_sword_frozen"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.LIGHTNER_AXE)
			.setIcon("icee:item/lightner_axe"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.LIGHTNER_AXE_FROZEN)
			.setIcon("icee:item/lightner_axe_frozen"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.ARMOR_HELMET_ICEE)
			.setIcon("icee:item/armor_helmet_icee"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.ARMOR_CHESTPLACE_ICEE)
			.setIcon("icee:item/armor_chestplate_icee"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.ARMOR_LEGGINGS_ICEE)
			.setIcon("icee:item/armor_leggings_icee"));
		dispatcher.addDispatch(new ItemModelStandard(IceeItems.ARMOR_BOOTS_ICEE)
			.setIcon("icee:item/armor_boots_icee"));



	}

	public void initEntityModels(EntityRendererDispatcher dispatcher) {

	}

	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}


}
