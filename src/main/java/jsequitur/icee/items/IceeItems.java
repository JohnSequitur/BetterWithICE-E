package jsequitur.icee.items;

import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;

import static jsequitur.icee.IceeMod.MOD_ID;

public class IceeItems {

	private static int startingID = 22222;
	public static int newID(){
		return startingID++;
	}
	public static Item ESSENCE;

	static ItemBuilder GenericItemBuilder = new ItemBuilder(MOD_ID);

	public static void initializeItems() {
		ESSENCE = GenericItemBuilder
			.build(new ItemEssence("essence", MOD_ID + ":item/essence", newID()));
	}


	public void afterItemInit() {
		initializeItems();
	}

}
