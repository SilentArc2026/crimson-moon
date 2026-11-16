package name.crimsonmoon.world.feature;

import com.mojang.serialization.Codec;
import name.crimsonmoon.block.ModBlocks;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.HugeFungusFeature;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class CharredHugeFungusFeature extends HugeFungusFeature {
    public CharredHugeFungusFeature(Codec<HugeFungusFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<HugeFungusFeatureConfig> context) {
        if (!super.generate(context)) {
            return false;
        }

        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        Random random = context.getRandom();
        HugeFungusFeatureConfig config = context.getConfig();

        BlockPos.Mutable mutablePos = new BlockPos.Mutable();
        for (int x = -4; x <= 4; x++) {
            for (int z = -4; z <= 4; z++) {
                for (int y = 4; y <= 26; y++) {
                    mutablePos.set(origin.getX() + x, origin.getY() + y, origin.getZ() + z);

                    if (world.getBlockState(mutablePos).isOf(config.hatState.getBlock())
                            && world.isAir(mutablePos.down())) {
                        if (random.nextFloat() < 0.15f) {
                            generateCharredVines(world, random, mutablePos.down());
                        }
                    }
                }
            }
        }

        return true;
    }

    private void generateCharredVines(WorldAccess world, Random random, BlockPos startPos) {
        BlockPos.Mutable pos = startPos.mutableCopy();
        int length = MathHelper.nextInt(random, 1, 5);

        for (int i = 0; i < length; i++) {
            if (!world.isAir(pos)) {
                break;
            }

            if (i == length - 1 || !world.isAir(pos.down())) {
                world.setBlockState(
                        pos,
                        ModBlocks.CHARRED_VINES.getDefaultState().with(AbstractPlantStemBlock.AGE, random.nextInt(25)),
                        Block.NOTIFY_LISTENERS
                );
                break;
            } else {
                world.setBlockState(
                        pos,
                        ModBlocks.CHARRED_VINES_PLANT.getDefaultState(),
                        Block.NOTIFY_LISTENERS
                );
            }
            pos.move(Direction.DOWN);
        }
    }
}