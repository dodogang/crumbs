package net.dodogang.ash.tag.api;

import net.dodogang.ash.impl.ImplLoader;
import net.minecraft.world.item.ItemStack;

public class Tools {
    public static abstract class Axe {
        private static final Axe IMPl = ImplLoader.load(Axe.class);

        /**
         * Checks whether the given item stack is an axe.
         *
         * @param stack the item stack
         * @return true if the item stack is an axe
         */
        public static boolean is(ItemStack stack) {
            return IMPl.isImpl(stack);
        }

        /**
         * Checks whether the given item stack can dig as an axe.
         *
         * fabric and quilt: will always return true if
         * {@link Axe#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can dig as an axe
         */
        public static boolean canDig(ItemStack stack) {
            return IMPl.canDigImpl(stack);
        }

        /**
         * Checks whether the given item stack can strip a log.
         *
         * fabric and quilt: will always return true if
         * {@link Axe#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can strip a log
         */
        public static boolean canStrip(ItemStack stack) {
            return IMPl.canStripImpl(stack);
        }

        /**
         * Checks whether the given item stack can scrape oxidization off of
         * copper.
         *
         * fabric and quilt: will always return true if
         * {@link Axe#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can scrape oxidization off of copper
         */
        public static boolean canScrape(ItemStack stack) {
            return IMPl.canScrapeImpl(stack);
        }

        /**
         * Checks whether the given item stack can remove wax off of copper.
         *
         * fabric and quilt: will always return true if
         * {@link Axe#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can remove wax off of copper
         */
        public static boolean canWaxOff(ItemStack stack) {
            return IMPl.canWaxOffImpl(stack);
        }

        protected abstract boolean isImpl(ItemStack stack);
        protected abstract boolean canDigImpl(ItemStack stack);
        protected abstract boolean canStripImpl(ItemStack stack);
        protected abstract boolean canScrapeImpl(ItemStack stack);
        protected abstract boolean canWaxOffImpl(ItemStack stack);
    }

    public static abstract class Hoe {
        private static final Hoe IMPl = ImplLoader.load(Hoe.class);

        /**
         * Checks whether the given item stack is a hoe.
         *
         * @param stack the item stack
         * @return true if the item stack is a hoe
         */
        public static boolean is(ItemStack stack) {
            return IMPl.isImpl(stack);
        }

        /**
         * Checks whether the given item stack can dig as a hoe.
         *
         * fabric and quilt: will always return true if
         * {@link Hoe#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can dig as a hoe
         */
        public static boolean canDig(ItemStack stack) {
            return IMPl.canDigImpl(stack);
        }

        /**
         * Checks whether the given item stack can turn dirt into soil.
         *
         * fabric and quilt: will always return true if
         * {@link Hoe#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can turn dirt into soil
         */
        public static boolean canTill(ItemStack stack) {
            return IMPl.canTillImpl(stack);
        }

        protected abstract boolean isImpl(ItemStack stack);
        protected abstract boolean canDigImpl(ItemStack stack);
        protected abstract boolean canTillImpl(ItemStack stack);
    }

    public static abstract class Shovel {
        private static final Shovel IMPl = ImplLoader.load(Shovel.class);

        /**
         * Checks whether the given item stack is a shovel.
         *
         * @param stack the item stack
         * @return true if the item stack is a shovel
         */
        public static boolean is(ItemStack stack) {
            return IMPl.isImpl(stack);
        }

        /**
         * Checks whether the given item stack can dig as a shovel.
         *
         * fabric and quilt: will always return true if
         * {@link Shovel#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can dig as a shovel
         */
        public static boolean canDig(ItemStack stack) {
            return IMPl.canDigImpl(stack);
        }

        /**
         * Checks whether the given item stack can turn dirt into path.
         *
         * fabric and quilt: will always return true if
         * {@link Shovel#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can turn dirt into path
         */
        public static boolean canFlatten(ItemStack stack) {
            return IMPl.canFlattenImpl(stack);
        }

        protected abstract boolean isImpl(ItemStack stack);
        protected abstract boolean canDigImpl(ItemStack stack);
        protected abstract boolean canFlattenImpl(ItemStack stack);
    }

    public static abstract class Pickaxe {
        private static final Pickaxe IMPl = ImplLoader.load(Pickaxe.class);

        /**
         * Checks whether the given item stack is a pickaxe.
         *
         * @param stack the item stack
         * @return true if the item stack is a pickaxe
         */
        public static boolean is(ItemStack stack) {
            return IMPl.isImpl(stack);
        }

        /**
         * Checks whether the given item stack can dig as a pickaxe.
         *
         * fabric and quilt: will always return true if
         * {@link Pickaxe#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can dig as a pickaxe
         */
        public static boolean canDig(ItemStack stack) {
            return IMPl.canDigImpl(stack);
        }

        protected abstract boolean isImpl(ItemStack stack);
        protected abstract boolean canDigImpl(ItemStack stack);
    }

    public static abstract class Sword {
        private static final Sword IMPl = ImplLoader.load(Sword.class);

        /**
         * Checks whether the given item stack is a sword.
         *
         * @param stack the item stack
         * @return true if the item stack is a sword
         */
        public static boolean is(ItemStack stack) {
            return IMPl.isImpl(stack);
        }

        /**
         * Checks whether the given item stack can dig as a sword.
         *
         * fabric and quilt: will always return true if
         * {@link Sword#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can dig as a sword
         */
        public static boolean canDig(ItemStack stack) {
            return IMPl.canDigImpl(stack);
        }

        /**
         * Checks whether the given item stack can perform a sweep attack.
         *
         * fabric and quilt: will always return true if
         * {@link Sword#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can perform a sweep attack
         */
        public static boolean canSweep(ItemStack stack) {
            return IMPl.canSweepImpl(stack);
        }

        protected abstract boolean isImpl(ItemStack stack);
        protected abstract boolean canDigImpl(ItemStack stack);
        protected abstract boolean canSweepImpl(ItemStack stack);
    }

    public static abstract class Shears {
        private static final Shears IMPl = ImplLoader.load(Shears.class);

        /**
         * Checks whether the given item stack is shears.
         *
         * @param stack the item stack
         * @return true if the item stack is shears
         */
        public static boolean is(ItemStack stack) {
            return IMPl.isImpl(stack);
        }

        /**
         * Checks whether the given item stack can dig as shears.
         *
         * fabric and quilt: will always return true if
         * {@link Shears#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can dig as shears
         */
        public static boolean canDig(ItemStack stack) {
            return IMPl.canDigImpl(stack);
        }

        /**
         * Checks whether the given item stack can harvest honey from a
         * beehive.
         *
         * fabric and quilt: will always return true if
         * {@link Shears#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can harvest honey from a beehive
         */
        public static boolean canHarvest(ItemStack stack) {
            return IMPl.canHarvestImpl(stack);
        }

        /**
         * Checks whether the given item stack can carve a pumpkin.
         *
         * fabric and quilt: will always return true if
         * {@link Shears#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can carve a pumpkin
         */
        public static boolean canCarve(ItemStack stack) {
            return IMPl.canCarveImpl(stack);
        }

        /**
         * Checks whether the given item stack can disarm a trip wire.
         *
         * fabric and quilt: will always return true if
         * {@link Shears#is(ItemStack)} returns true.
         *
         * @param stack the item stack
         * @return true if the item stack can disarm a trip wire
         */
        public static boolean canDisarm(ItemStack stack) {
            return IMPl.canDisarmImpl(stack);
        }

        protected abstract boolean isImpl(ItemStack stack);
        protected abstract boolean canDigImpl(ItemStack stack);
        protected abstract boolean canHarvestImpl(ItemStack stack);
        protected abstract boolean canCarveImpl(ItemStack stack);
        protected abstract boolean canDisarmImpl(ItemStack stack);
    }
}
