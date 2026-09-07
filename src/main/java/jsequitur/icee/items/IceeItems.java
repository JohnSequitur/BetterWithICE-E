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
	public static ItemFood PEZZA_KETCHUP_1;
	public static ItemFood PEZZA_KETCHUP_2;
	public static ItemFood PEZZA_KETCHUP_3;
	public static ItemFood PEZZA_KETCHUP_4;
	public static ItemFood KETCHUP;
	public static ItemToolSword LIGHTNER_SWORD;
	public static Item LIGHTNER_SWORD_FROZEN;
	public static ItemToolAxe LIGHTNER_AXE;
	public static Item LIGHTNER_AXE_FROZEN;



	static ItemBuilder genericItemBuilder = new ItemBuilder(MOD_ID)
		.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS));

	public static void initializeItems() {
		ESSENCE = genericItemBuilder
			.build(new Item("essence", MOD_ID + ":item/essence", newID()));
		PEZZA = genericItemBuilder
			.build(new ItemFood("pezza", MOD_ID + ":item/pezza", newID(), 4, 10, false, 4));
		PEZZA_KETCHUP_1 = genericItemBuilder
			.build(new ItemFood("pezza.ketchup.1", MOD_ID + ":item/pezza_ketchup_1", newID(), 5, 10, false, 4));
		PEZZA_KETCHUP_2 = genericItemBuilder
			.build(new ItemFood("pezza.ketchup.2", MOD_ID + ":item/pezza_ketchup_2", newID(), 6, 10, false, 4));
		PEZZA_KETCHUP_3 = genericItemBuilder
			.build(new ItemFood("pezza.ketchup.3", MOD_ID + ":item/pezza_ketchup_3", newID(), 7, 10, false, 4));
		PEZZA_KETCHUP_4 = genericItemBuilder
			.build(new ItemFood("pezza.ketchup.4", MOD_ID + ":item/pezza_ketchup_4", newID(), 8, 10, false, 4));
		PEZZA_FROZEN = genericItemBuilder
			.build(new ItemFood("pezza.frozen", MOD_ID + ":item/pezza_frozen", newID(), 4, 40, false, 4));
		KETCHUP = genericItemBuilder
			.build(new ItemFood("ketchup", MOD_ID + ":item/ketchup", newID(), 1, 10, false, 8));
		LIGHTNER_SWORD = genericItemBuilder
			.build(new ItemToolSword("tool.sword.lightner", MOD_ID + ":item/tool_sword_lightner", newID(), new ToolMaterial()
				.setDurability(768).setEfficiency(4F, 6F).setMiningLevel(3).setDamage(6).setBlockHitDelay(6)));
		LIGHTNER_SWORD_FROZEN = genericItemBuilder
			.setStackSize(1)
			.build(new Item("sword.lightner.frozen", MOD_ID + ":item/sword_lightner_frozen", newID()));
		LIGHTNER_AXE = genericItemBuilder
			.build(new ItemToolAxe("tool.axe.lightner", MOD_ID + ":item/tool_axe_lightner", newID(), new ToolMaterial()
				.setDurability(768).setEfficiency(4F, 6F).setMiningLevel(3).setDamage(6).setBlockHitDelay(6)));
		LIGHTNER_AXE_FROZEN = genericItemBuilder
			.setStackSize(1)
			.build(new Item("axe.lightner.frozen", MOD_ID + ":item/axe_lightner_frozen", newID()));


	}


	public void afterItemInit() {
		initializeItems();
	}

}
