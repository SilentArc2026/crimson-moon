package name.crimsonmoon.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import name.crimsonmoon.world.tree.ModFoliagePlacerTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class PalmFoliagePlacer extends FoliagePlacer {
    public static final Codec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.create((instance -> fillFoliagePlacerFields(instance)
            .and(Codec.intRange(0, 12).fieldOf("height").forGetter((placer) -> placer.height)).apply(instance, PalmFoliagePlacer::new)));
    private final int height;


    public PalmFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.PALM_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        BlockPos center = treeNode.getCenter().up(offset);

        // 1. Core crown
        placeFoliageBlock(world, placer, random, config, center);
        placeFoliageBlock(world, placer, random, config, center.up());

        // 2. Long Cardinal Fronds (6 blocks outward + drooping tip)
        Direction[] cardinals = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
        for (Direction dir : cardinals) {
            placeFoliageBlock(world, placer, random, config, center.offset(dir, 1));
            placeFoliageBlock(world, placer, random, config, center.offset(dir, 1).up());
            placeFoliageBlock(world, placer, random, config, center.offset(dir, 2).up());
            placeFoliageBlock(world, placer, random, config, center.offset(dir, 3).up());
            placeFoliageBlock(world, placer, random, config, center.offset(dir, 4));
            placeFoliageBlock(world, placer, random, config, center.offset(dir, 5));
            placeFoliageBlock(world, placer, random, config, center.offset(dir, 5).down());
            placeFoliageBlock(world, placer, random, config, center.offset(dir, 6).down());
        }

        // 3. Long Diagonal Fronds (Orthogonally bridged so distance flows smoothly)
        int[][] diagonals = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        for (int[] diag : diagonals) {
            int dx = diag[0];
            int dz = diag[1];

            placeFoliageBlock(world, placer, random, config, center.add(dx, 0, 0));
            placeFoliageBlock(world, placer, random, config, center.add(dx, 0, dz));
            placeFoliageBlock(world, placer, random, config, center.add(dx * 2, 0, dz));
            placeFoliageBlock(world, placer, random, config, center.add(dx * 2, 0, dz * 2));
            placeFoliageBlock(world, placer, random, config, center.add(dx * 3, 0, dz * 2));
            placeFoliageBlock(world, placer, random, config, center.add(dx * 3, 0, dz * 3));
            placeFoliageBlock(world, placer, random, config, center.add(dx * 3, -1, dz * 3));
            placeFoliageBlock(world, placer, random, config, center.add(dx * 4, -1, dz * 3));
            placeFoliageBlock(world, placer, random, config, center.add(dx * 4, -1, dz * 4));
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
