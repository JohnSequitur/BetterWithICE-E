package jsequitur.icee.world.feature;

import jsequitur.icee.world.feature.pipes.WorldFeaturePipes;

import static net.minecraft.core.net.command.util.CommandHelper.registerWorldFeatureClass;

public class IceeWorldFeatures {
	private static boolean hasInit = false;

	public static void init() {
		if (!hasInit) {
			hasInit = true;
			initializeWorldFeatures();
		}

	}

	private static void initializeWorldFeatures() {
		registerWorldFeatureClass(WorldFeaturePipes.class, "Pipes");
//		registerWorldFeatureClass(WorldFeatureAetherSilverDungeon.class, "Temple");
//		registerWorldFeatureClass(WorldFeatureAetherGoldDungeon.class, "Sanctuary");
//		registerWorldFeatureClass(WorldFeatureAetherClouds.class, "Clouds");
//		registerWorldFeatureClass(WorldFeatureAetherLiquid.class, "AetherLakes");
//		registerWorldFeatureClass(WorldFeatureAetherOre.class, "AetherOre");
//		registerWorldFeatureClass(WorldFeatureAetherTree.class, "TreeSkyroot");
//		registerWorldFeatureClass(WorldFeatureAetherTreeGoldenOak.class, "TreeGoldenSkyroot");
//		registerWorldFeatureClass(WorldFeatureAetherQuicksoil.class, "Quicksoil");
//
//		registerWorldFeatureClass(WorldFeatureAetherGoldChest.class, "SanctuaryTreasure");
//		registerWorldFeatureClass(WorldFeatureAetherSilverChest.class, "TempleTreasure");
//		registerWorldFeatureClass(WorldFeatureAetherBronzeChest.class, "MazeTreasure");
	}
}
