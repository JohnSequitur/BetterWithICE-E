package jsequitur.icee.mixin;

import jsequitur.icee.world.feature.pipes.WorldFeaturePipes;
import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(ChunkDecoratorOverworld.class)
public class ChunkDecoratorMixin {

	@Shadow
	@Final
	private @NotNull World world;

	@Inject(method = "decorate", at = @At("TAIL"), cancellable = true)
	private void generatePipes(Chunk chunk, CallbackInfo ci) {
		try {
			int chunkX = chunk.pos.x;
			int chunkZ = chunk.pos.z;

			int minY = this.world.getWorldType().getMinY(this.world);
			int maxY = this.world.getWorldType().getMaxY(this.world);
			int rangeY = maxY + 1 - minY;
			float oreHeightModifier = (float)rangeY / 128.0F;
			int x = chunkX * 16;
			int z = chunkZ * 16;
			int y = this.world.getHeightValue(x + 16, z + 16);

			Random rand = new Random(this.world.getRandomSeed());
			long l1 = rand.nextLong() / 2L * 2L + 1L;
			long l2 = rand.nextLong() / 2L * 2L + 1L;

			rand.setSeed(
				(long) chunkX * l1 +
					(long) chunkZ * l2 ^
					this.world.getRandomSeed()
			);

			if (rand.nextInt(100) == 0) {
				new WorldFeaturePipes().place(this.world, rand, x, y, z);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
