package jsequitur.icee.items;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemToolAxe;
import net.minecraft.core.item.tool.ItemToolSword;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;

import static jsequitur.icee.IceeMod.MOD_ID;

public class IceeItems {

	private static int startingID = 22222;
	public static int newID(){
		return startingID++;
	}
	public static Item ESSENCE;
	public static ItemFood PEZZA;
	public static ItemFood PEZZA_FROZEN;
	public static ItemFood KETCHUP;
	public static ItemToolSword LIGHTNER_SWORD;
	public static ItemToolSword LIGHTNER_SWORD_FROZEN;
	public static ItemToolAxe LIGHTNER_AXE;
	public static ItemToolAxe LIGHTNER_AXE_FROZEN;



	static ItemBuilder genericItemBuilder = new ItemBuilder(MOD_ID)
		.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS));

	public static void initializeItems() {
		ESSENCE = genericItemBuilder
			.build(new Item("essence", MOD_ID + ":item/essence", newID()));
		PEZZA = genericItemBuilder
			.build(new ItemFood("pezza", MOD_ID + ":item/pezza", newID(), 4, 10, false, 4));
		PEZZA_FROZEN = genericItemBuilder
			.build(new ItemFood("pezza.frozen", MOD_ID + ":item/pezza_frozen", newID(), 4, 40, false, 4));
		KETCHUP = genericItemBuilder
			.build(new ItemFood("ketchup", MOD_ID + ":item/ketchup", newID(), 1, 10, false, 8));
		LIGHTNER_SWORD = genericItemBuilder
			.build(new ItemToolSword("tool.sword.lightner", MOD_ID + ":item/tool_sword_lightner", newID(), new ToolMaterial()
				.setDurability(768).setEfficiency(4F, 6F).setMiningLevel(3).setDamage(6).setBlockHitDelay(6)));
		LIGHTNER_SWORD_FROZEN = genericItemBuilder
			.build(new ItemToolSword("tool.sword.lightner.frozen", MOD_ID + ":item/tool_sword_lightner_frozen", newID(), new ToolMaterial()
				.setDurability(64).setEfficiency(1F, 2F).setMiningLevel(2).setDamage(2).setBlockHitDelay(10)));
		LIGHTNER_AXE = genericItemBuilder
			.build(new ItemToolAxe("tool.axe.lightner", MOD_ID + ":item/tool_axe_lightner", newID(), new ToolMaterial()
				.setDurability(768).setEfficiency(4F, 6F).setMiningLevel(3).setDamage(6).setBlockHitDelay(6)));
		LIGHTNER_AXE_FROZEN = genericItemBuilder
			.build(new ItemToolAxe("tool.axe.lightner.frozen", MOD_ID + ":item/tool_axe_lightner_frozen", newID(), new ToolMaterial()
				.setDurability(64).setEfficiency(1F, 2F).setMiningLevel(2).setDamage(2).setBlockHitDelay(10)));


	}


	public void afterItemInit() {
		initializeItems();
	}

}
