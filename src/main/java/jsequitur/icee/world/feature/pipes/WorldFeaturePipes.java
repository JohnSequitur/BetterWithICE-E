package jsequitur.icee.world.feature.pipes;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.pos.TilePos;

import java.util.Random;

public class WorldFeaturePipes extends WorldFeature {
	public static Block OUTER_PIPE_BLOCK = Blocks.WOOL;
	int junctionWidth = 4;
	int pipeWidth = 5;
	int minPipeLength = 10;
	int maxPipeLength = 30;
	int minVerticalPipeLength = 5;
	int maxVerticalPipeLength = 15;
	public WorldFeaturePipes() {}
	Random rand;
	@Override
	public boolean place(World world, Random random, int x, int y, int z) {
//		for (int i = 0; i < world.getWorldType().getMaxY(world); i++) {
//			world.setBlockType(new TilePos(x, i, z), Blocks.GLOWSTONE);
//		}
//		for (int i = 0; i < 20; i++) {
//			world.setBlockType(new TilePos(x + i, y, z), Blocks.WOOL);
//		}
		rand = random;
		junction(world, random, x, y, z, 0);
		return true;
	}
	// type = 0: base, type = 1: posX, type = 2: posZ, type = 3: negX, type = 4: negZ
	private void junction(World world, Random random, int x, int y, int z, int type, boolean blockFloor) {
		for (int i = 0; i < junctionWidth; i++) {
			for (int j = 0; j < junctionWidth; j++) {
				for (int k = 0; k < junctionWidth; k++) {
					if (atLeastTwo(i == 0 || i == 3, j == 0 || j == 3, k == 0 || k == 3) || (type == 0 && (j == 0 || j == 3)) || (blockFloor && j == 0)) {
						world.setBlockType(new TilePos(x + i, y + j, z + k), Blocks.GLOWSTONE);
					}
					else {
						world.setBlockType(new TilePos(x + i, y + j, z + k), Blocks.AIR);
					}
				}
			}
		}
		if (type == 0) {
			if (extend()) {
				posXPipe(world, random, x + junctionWidth, y, z, minPipeLength + random.nextInt(maxPipeLength - minPipeLength));
			}
			if (extend()) {
				posZPipe(world, random, x, y, z + junctionWidth, minPipeLength + random.nextInt(maxPipeLength - minPipeLength));
			}
			if (extend()) {
				negXPipe(world, random, x - 1, y, z, minPipeLength + random.nextInt(maxPipeLength - minPipeLength));
			}
			if (extend()) {
				negZPipe(world, random, x, y, z - 1, minPipeLength + random.nextInt(maxPipeLength - minPipeLength));
			}
//			if (random.nextInt(2) == 0) {
//				posYPipe(world, random, x, y + junctionWidth, z, minVerticalPipeLength + random.nextInt(maxVerticalPipeLength - minVerticalPipeLength));
//			}
		}
		else if (type == 1) {
			if (extend()) {
				posXPipe(world, random, x + junctionWidth, y, z, minPipeLength + random.nextInt(maxPipeLength - minPipeLength));
			}
			if (extend()) {
				posZPipe(world, random, x, y, z + junctionWidth, minPipeLength + random.nextInt(maxPipeLength - minPipeLength));
			}
			if (extend()) {
				posYPipe(world, random, x, y + junctionWidth, z, minVerticalPipeLength + random.nextInt(maxVerticalPipeLength - minVerticalPipeLength), type);
			}
		}
		else if (type == 2) {
			if (extend()) {
				negXPipe(world, random, x - 1, y, z, minPipeLength + random.nextInt(maxPipeLength - minPipeLength));
			}
			if (extend()) {
				posZPipe(world, random, x, y, z + junctionWidth, minPipeLength + random.nextInt(maxPipeLength - minPipeLength));
			}
			if (extend()) {
				posYPipe(world, random, x, y + junctionWidth, z, minVerticalPipeLength + random.nextInt(maxVerticalPipeLength - minVerticalPipeLength), type);
			}
		}
		else if (type == 3) {
			if (extend()) {
				negXPipe(world, random, x - 1, y, z, minPipeLength + random.nextInt(maxPipeLength - minPipeLength));
			}
			if (extend()) {
				negZPipe(world, random, x, y, z - 1, minPipeLength + random.nextInt(maxPipeLength - minPipeLength));
			}
			if (extend()) {
				posYPipe(world, random, x, y + junctionWidth, z, minVerticalPipeLength + random.nextInt(maxVerticalPipeLength - minVerticalPipeLength), type);
			}
		}
		else if (type == 4) {
			if (extend()) {
				posXPipe(world, random, x + junctionWidth, y, z, minPipeLength + random.nextInt(maxPipeLength - minPipeLength));
			}
			if (extend()) {
				negZPipe(world, random, x, y, z - 1, minPipeLength + random.nextInt(maxPipeLength - minPipeLength));
			}
			if (extend()) {
				posYPipe(world, random, x, y + junctionWidth, z, minVerticalPipeLength + random.nextInt(maxVerticalPipeLength - minVerticalPipeLength), type);
			}
		}
	}
	private void junction(World world, Random random, int x, int y, int z, int type) {
		junction(world, random, x, y, z, type, true);
	}
	private void posXPipe(World world, Random random, int x, int y, int z, int depth) {
		for (int i = 0; i < depth; i++) {
			world.setBlockType(new TilePos(x + i, y, z + 0), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + i, y, z + 1), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + i, y, z + 2), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + i, y, z + 3), Blocks.PLANKS_OAK);
//			world.setBlockType(new TilePos(x + i, y, z + 4), Blocks.PLANKS_OAK);

			world.setBlockType(new TilePos(x + i, y + junctionWidth - 1, z + 0), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + i, y + junctionWidth - 1, z + 1), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + i, y + junctionWidth - 1, z + 2), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + i, y + junctionWidth - 1, z + 3), Blocks.PLANKS_OAK);
//			world.setBlockType(new TilePos(x + i, y + junctionWidth - 1, z + 4), Blocks.PLANKS_OAK);

			world.setBlockType(new TilePos(x + i, y + 1, z + 0), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + i, y + 1, z + 3), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + i, y + 2, z + 0), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + i, y + 2, z + 3), Blocks.PLANKS_OAK);
			world.setBlockType(new TilePos(x + i, y + 1, z + 1), Blocks.AIR);
			world.setBlockType(new TilePos(x + i, y + 1, z + 2), Blocks.AIR);
			world.setBlockType(new TilePos(x + i, y + 2, z + 1), Blocks.AIR);
			world.setBlockType(new TilePos(x + i, y + 2, z + 2), Blocks.AIR);
		}
		if (random.nextInt(2) == 0) {
			junction(world, random, x + depth, y, z, 1);
		}

	}
	private void posZPipe(World world, Random random, int x, int y, int z, int depth) {
		for (int i = 0; i < depth; i++) {
			world.setBlockType(new TilePos(x + 0, y, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 1, y, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 2, y, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 3, y, z + i), Blocks.WOOL);
//			world.setBlockType(new TilePos(x + 4, y, z + i), Blocks.PLANKS_OAK);

			world.setBlockType(new TilePos(x + 0, y + junctionWidth - 1, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 1, y + junctionWidth - 1, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 2, y + junctionWidth - 1, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 3, y + junctionWidth - 1, z + i), Blocks.WOOL);
//			world.setBlockType(new TilePos(x + 4, y + junctionWidth - 1, z + i), Blocks.PLANKS_OAK);

			world.setBlockType(new TilePos(x + 0, y + 1, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 3, y + 1, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 0, y + 2, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 3, y + 2, z + i), Blocks.WOOL);
			world.setBlockType(new TilePos(x + 1, y + 1, z + i), Blocks.AIR);
			world.setBlockType(new TilePos(x + 2, y + 1, z + i), Blocks.AIR);
			world.setBlockType(new TilePos(x + 1, y + 2, z + i), Blocks.AIR);
			world.setBlockType(new TilePos(x + 2, y + 2, z + i), Blocks.AIR);
		}
		if (random.nextInt(2) == 0) {
			junction(world, random, x, y, z + depth, 2);
		}
	}

	private void posYPipe(World world, Random random, int x, int y, int z, int depth, int nextJunctionType) {
		for (int i = 0; i < depth; i++) {
			world.setBlockType(new TilePos(x + 0, y + i, z), Blocks.BLOCK_DIAMOND);
			world.setBlockType(new TilePos(x + 1, y + i, z), Blocks.BLOCK_DIAMOND);
			world.setBlockType(new TilePos(x + 2, y + i, z), Blocks.BLOCK_DIAMOND);
			world.setBlockType(new TilePos(x + 3, y + i, z), Blocks.BLOCK_DIAMOND);
//			world.setBlockType(new TilePos(x + 4, y + i, z), Blocks.PLANKS_OAK);

			world.setBlockType(new TilePos(x + 0, y + i, z + junctionWidth - 1), Blocks.BLOCK_DIAMOND);
			world.setBlockType(new TilePos(x + 1, y + i, z + junctionWidth - 1), Blocks.BLOCK_DIAMOND);
			world.setBlockType(new TilePos(x + 2, y + i, z + junctionWidth - 1), Blocks.BLOCK_DIAMOND);
			world.setBlockType(new TilePos(x + 3, y + i, z + junctionWidth - 1), Blocks.BLOCK_DIAMOND);
//			world.setBlockType(new TilePos(x + 4, y + i, z + junctionWidth - 1), Blocks.PLANKS_OAK);

			world.setBlockType(new TilePos(x + 0, y + i, z + 1), Blocks.BLOCK_DIAMOND);
			world.setBlockType(new TilePos(x + 3, y + i, z + 1), Blocks.BLOCK_DIAMOND);
			world.setBlockType(new TilePos(x + 0, y + i, z + 2), Blocks.BLOCK_DIAMOND);
			world.setBlockType(new TilePos(x + 3, y + i, z + 2), Blocks.BLOCK_DIAMOND);
			world.setBlockType(new TilePos(x + 1, y + i, z + 1), Blocks.AIR);
			world.setBlockType(new TilePos(x + 2, y + i, z + 1), Blocks.AIR);
			world.setBlockType(new TilePos(x + 1, y + i, z + 2), Blocks.AIR);
			world.setBlockType(new TilePos(x + 2, y + i, z + 2), Blocks.AIR);
		}
		if (random.nextInt(2) == 0) {
			junction(world, random, x, y + depth, z, nextJunctionType, false);
		}
	}
	private void negXPipe(World world, Random random, int x, int y, int z, int depth) {
		for (int i = 0; i < depth; i++) {
			world.setBlockType(new TilePos(x - i, y, z + 0), Blocks.BLOCK_LAPIS);
			world.setBlockType(new TilePos(x - i, y, z + 1), Blocks.BLOCK_LAPIS);
			world.setBlockType(new TilePos(x - i, y, z + 2), Blocks.BLOCK_LAPIS);
			world.setBlockType(new TilePos(x - i, y, z + 3), Blocks.BLOCK_LAPIS);

			world.setBlockType(new TilePos(x - i, y + junctionWidth - 1, z + 0), Blocks.BLOCK_LAPIS);
			world.setBlockType(new TilePos(x - i, y + junctionWidth - 1, z + 1), Blocks.BLOCK_LAPIS);
			world.setBlockType(new TilePos(x - i, y + junctionWidth - 1, z + 2), Blocks.BLOCK_LAPIS);
			world.setBlockType(new TilePos(x - i, y + junctionWidth - 1, z + 3), Blocks.BLOCK_LAPIS);

			world.setBlockType(new TilePos(x - i, y + 1, z + 0), Blocks.BLOCK_LAPIS);
			world.setBlockType(new TilePos(x - i, y + 1, z + 3), Blocks.BLOCK_LAPIS);
			world.setBlockType(new TilePos(x - i, y + 2, z + 0), Blocks.BLOCK_LAPIS);
			world.setBlockType(new TilePos(x - i, y + 2, z + 3), Blocks.BLOCK_LAPIS);
			world.setBlockType(new TilePos(x - i, y + 1, z + 1), Blocks.AIR);
			world.setBlockType(new TilePos(x - i, y + 1, z + 2), Blocks.AIR);
			world.setBlockType(new TilePos(x - i, y + 2, z + 1), Blocks.AIR);
			world.setBlockType(new TilePos(x - i, y + 2, z + 2), Blocks.AIR);
		}
		if (random.nextInt(2) == 0) {
			junction(world, random, x + depth, y, z, 3);
		}
	}
	private void negZPipe(World world, Random random, int x, int y, int z, int depth) {
		for (int i = 0; i < depth; i++) {
			world.setBlockType(new TilePos(x + 0, y, z - i), Blocks.BLOCK_GOLD);
			world.setBlockType(new TilePos(x + 1, y, z - i), Blocks.BLOCK_GOLD);
			world.setBlockType(new TilePos(x + 2, y, z - i), Blocks.BLOCK_GOLD);
			world.setBlockType(new TilePos(x + 3, y, z - i), Blocks.BLOCK_GOLD);

			world.setBlockType(new TilePos(x + 0, y + junctionWidth - 1, z - i), Blocks.BLOCK_GOLD);
			world.setBlockType(new TilePos(x + 1, y + junctionWidth - 1, z - i), Blocks.BLOCK_GOLD);
			world.setBlockType(new TilePos(x + 2, y + junctionWidth - 1, z - i), Blocks.BLOCK_GOLD);
			world.setBlockType(new TilePos(x + 3, y + junctionWidth - 1, z - i), Blocks.BLOCK_GOLD);

			world.setBlockType(new TilePos(x + 0, y + 1, z - i), Blocks.BLOCK_GOLD);
			world.setBlockType(new TilePos(x + 3, y + 1, z - i), Blocks.BLOCK_GOLD);
			world.setBlockType(new TilePos(x + 0, y + 2, z - i), Blocks.BLOCK_GOLD);
			world.setBlockType(new TilePos(x + 3, y + 2, z - i), Blocks.BLOCK_GOLD);
			world.setBlockType(new TilePos(x + 1, y + 1, z - i), Blocks.AIR);
			world.setBlockType(new TilePos(x + 2, y + 1, z - i), Blocks.AIR);
			world.setBlockType(new TilePos(x + 1, y + 2, z - i), Blocks.AIR);
			world.setBlockType(new TilePos(x + 2, y + 2, z - i), Blocks.AIR);
		}
		if (random.nextInt(2) == 0) {
			junction(world, random, x, y, z + depth, 4);
		}
	}
	boolean atLeastTwo(boolean a, boolean b, boolean c) {
		return a ? (b || c) : (b && c);
	}
	boolean extend() {
		return rand.nextInt(3) < 2;
	}
}
