package name.crimsonmoon.util;

import name.crimsonmoon.CrimsonMoon;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> BLOOD_MOON_BLOCKS =
                createBlockTag("blood_moon_blocks");
        public static final TagKey<Block> PAXEL_MINEABLE =
                createBlockTag("mineable/paxel");
        public static final TagKey<Block> CORRUPTED_LOGS =
                createBlockTag("corrupted_logs");
        public static final TagKey<Block> ACIDIC_LOGS =
                createBlockTag("acidic_logs");
        public static final TagKey<Block> CHARRED_LOGS =
                createBlockTag("charred_logs");
        public static final TagKey<Block> PALM_LOGS =
                createBlockTag("palm_logs");
        public static final TagKey<Block> WITHERED_PALM_LOGS =
                createBlockTag("withered_palm_logs");

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(CrimsonMoon.MOD_ID, name));
        }
        private static TagKey<Block> createCommonBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }
    }


    public static class Items {
        public static final TagKey<Item> CORRUPTED_LOGS = createItemTag("corrupted_logs");
        public static final TagKey<Item> ACIDIC_LOGS = createItemTag("acidic_logs");
        public static final TagKey<Item> CHARRED_LOGS = createItemTag("charred_logs");
        public static final TagKey<Item> PALM_LOGS = createItemTag("palm_logs");
        public static final TagKey<Item> WITHERED_PALM_LOGS = createItemTag("withered_palm_logs");

        public static TagKey<Item> createItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(CrimsonMoon.MOD_ID, name));
        }
        private static TagKey<Item> createCommonItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier("c", name));
        }
    }
}
