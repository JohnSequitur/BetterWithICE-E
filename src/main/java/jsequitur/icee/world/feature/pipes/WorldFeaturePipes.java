package jsequitur.icee.world.feature.pipes;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.pos.TilePos;

import java.util.Random;

public class WorldFeaturePipes extends WorldFeature {
	public static Block OUTER_PIPE_BLOCK = Blocks.WOOL;
	int junctionWidth = 5;
	int pipeWidth = 5;
	int minPipeLength = 10;
	public WorldFeaturePipes() {}
	@Override
	public boolean place(World world, Random random, int x, int y, int z) {
//		for (int i = 0; i < world.getWorldType().getMaxY(world); i++) {
//			world.setBlockType(new TilePos(x, i, z), Blocks.GLOWSTONE);
//		}
//		for (int i = 0; i < 20; i++) {
//			world.setBlockType(new TilePos(x + i, y, z), Blocks.WOOL);
//		}
		junction(world, random, x, y, z);
		return true;
	}

	private void junction(World world, Random random, int x, int y, int z) {
//		for (int i = 0; i < junctionWidth; i++) {
//			for (int j = 0; j < junctionWidth; j++) {
//				for (int k = 0; k < junctionWidth; k++) {
//					world.setBlockType(new TilePos(x + i, y + j, z + k), Blocks.GLOWSTONE);
//				}
//			}
//		}
		for (int i = 0; i < junctionWidth; i++) {
			for (int j = 0; j < junctionWidth; j++) {
				world.setBlockType(new TilePos(x + i, y, z + j), Blocks.GLOWSTONE);
				world.setBlockType(new TilePos(x + i, y + junctionWidth - 1, z + j), Blocks.GLOWSTONE);
			}
		}
		if (random.nextInt(2) == 0) {
			posXPipe(world, random, x + junctionWidth, y, z, minPipeLength + random.nextInt(20));
		}
		if (random.nextInt(2) == 0) {
			posZPipe(world, random, x, y, z + junctionWidth, minPipeLength + random.nextInt(20));
		}
		if (random.nextInt(2) == 0) {
			posYPipe(world, random, x, y + junctionWidth, z, minPipeLength + random.nextInt(20));
		}
	}
	private void posXPipe(World world, Random random, int x, int y, int z, int depth) {
		for (int i = 0; i < depth; i++) {
			world.setBlockType(new TilePos(x + i, y, z + 0), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + i, y, z + 1), Blocks.WOOL);
			world.setBlockType(new TilePos(x + i, y, z + 2), Blocks.BEDROCK);
			world.setBlockType(new TilePos(x + i, y, z + 3), Blocks.WOOL);
			world.setBlockType(new TilePos(x + i, y, z + 4), Blocks.PLANKS_OAK);

			world.setBlockType(new TilePos(x + i, y + junctionWidth - 1, z + 0), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + i, y + junctionWidth - 1, z + 1), Blocks.WOOL);
			world.setBlockType(new TilePos(x + i, y + junctionWidth - 1, z + 2), Blocks.BEDROCK);
			world.setBlockType(new TilePos(x + i, y + junctionWidth - 1, z + 3), Blocks.WOOL);
			world.setBlockType(new TilePos(x + i, y + junctionWidth - 1, z + 4), Blocks.PLANKS_OAK);
		}
		if (random.nextInt(2) == 0) {
			junction(world, random, x + depth, y, z);
		}

	}
	private void posZPipe(World world, Random random, int x, int y, int z, int depth) {
		for (int i = 0; i < depth; i++) {
			world.setBlockType(new TilePos(x + 0, y, z + i), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + 1, y, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 2, y, z + i), Blocks.BEDROCK);
			world.setBlockType(new TilePos(x + 3, y, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 4, y, z + i), Blocks.PLANKS_OAK);

			world.setBlockType(new TilePos(x + 0, y + junctionWidth - 1, z + i), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + 1, y + junctionWidth - 1, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 2, y + junctionWidth - 1, z + i), Blocks.BEDROCK);
			world.setBlockType(new TilePos(x + 3, y + junctionWidth - 1, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 4, y + junctionWidth - 1, z + i), Blocks.PLANKS_OAK);
		}
		if (random.nextInt(2) == 0) {
			junction(world, random, x, y, z + depth);
		}
	}

	private void posYPipe(World world, Random random, int x, int y, int z, int depth) {
		for (int i = 0; i < depth; i++) {
			world.setBlockType(new TilePos(x + 0, y + i, z), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + 1, y + i, z), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 2, y + i, z), Blocks.BEDROCK);
			world.setBlockType(new TilePos(x + 3, y + i, z), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 4, y + i, z), Blocks.PLANKS_OAK);

			world.setBlockType(new TilePos(x + 0, y + i, z + junctionWidth - 1), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + 1, y + i, z + junctionWidth - 1), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 2, y + i, z + junctionWidth - 1), Blocks.BEDROCK);
			world.setBlockType(new TilePos(x + 3, y + i, z + junctionWidth - 1), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 4, y + i, z + junctionWidth - 1), Blocks.PLANKS_OAK);
		}
		if (random.nextInt(2) == 0) {
			junction(world, random, x, y + depth, z);
		}
	}
}
