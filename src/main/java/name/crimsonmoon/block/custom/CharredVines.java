package name.crimsonmoon.block.custom;

import name.crimsonmoon.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public interface CharredVines {
    BooleanProperty BERRIES = Properties.BERRIES;

    static ActionResult pickBerries(@Nullable Entity picker, BlockState state, World world, BlockPos pos) {
        if (state.get(BERRIES)) {
            Block.dropStack(world, pos, new ItemStack(ModItems.GLOOM_BERRIES, 1));
            float pitch = MathHelper.nextBetween(world.random, 0.8F, 1.2F);
            world.playSound(null, pos, SoundEvents.BLOCK_CAVE_VINES_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, pitch);
            BlockState newState = state.with(BERRIES, false);
            world.setBlockState(pos, newState, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(picker, newState));
            return ActionResult.success(world.isClient);
        }
        return ActionResult.PASS;
    }

    static boolean hasBerries(BlockState state) {
        return state.contains(BERRIES) && state.get(BERRIES);
    }

    // Optional: Gives off light when berries are grown (set to 0 if you don't want them to glow)
    static ToIntFunction<BlockState> getLuminanceSupplier(int luminance) {
        return state -> state.get(Properties.BERRIES) ? luminance : 0;
    }
}