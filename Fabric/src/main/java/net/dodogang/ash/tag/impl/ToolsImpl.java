package net.dodogang.ash.tag.impl;

import net.dodogang.ash.tag.api.Tools;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.world.item.ItemStack;

public class ToolsImpl {
    public static class AxeImpl extends Tools.Axe {
        @Override
        protected boolean isImpl(ItemStack stack) {
            return stack.is(ConventionalItemTags.AXES);
        }

        @Override
        protected boolean canDigImpl(ItemStack stack) {
            return isImpl(stack);
        }

        @Override
        protected boolean canStripImpl(ItemStack stack) {
            return isImpl(stack);
        }

        @Override
        protected boolean canScrapeImpl(ItemStack stack) {
            return isImpl(stack);
        }

        @Override
        protected boolean canWaxOffImpl(ItemStack stack) {
            return isImpl(stack);
        }
    }

    public static class HoeImpl extends Tools.Hoe {
        @Override
        protected boolean isImpl(ItemStack stack) {
            return stack.is(ConventionalItemTags.HOES);
        }

        @Override
        protected boolean canDigImpl(ItemStack stack) {
            return isImpl(stack);
        }

        @Override
        protected boolean canTillImpl(ItemStack stack) {
            return isImpl(stack);
        }
    }

    public static class ShovelImpl extends Tools.Shovel {
        @Override
        protected boolean isImpl(ItemStack stack) {
            return stack.is(ConventionalItemTags.SHOVELS);
        }

        @Override
        protected boolean canDigImpl(ItemStack stack) {
            return isImpl(stack);
        }

        @Override
        protected boolean canFlattenImpl(ItemStack stack) {
            return isImpl(stack);
        }
    }

    public static class PickaxeImpl extends Tools.Pickaxe {
        @Override
        protected boolean isImpl(ItemStack stack) {
            return stack.is(ConventionalItemTags.SHOVELS);
        }

        @Override
        protected boolean canDigImpl(ItemStack stack) {
            return isImpl(stack);
        }
    }

    public static class SwordImpl extends Tools.Sword {
        @Override
        protected boolean isImpl(ItemStack stack) {
            return stack.is(ConventionalItemTags.SHOVELS);
        }

        @Override
        protected boolean canDigImpl(ItemStack stack) {
            return isImpl(stack);
        }

        @Override
        protected boolean canSweepImpl(ItemStack stack) {
            return isImpl(stack);
        }
    }

    public static class ShearsImpl extends Tools.Shears {
        @Override
        protected boolean isImpl(ItemStack stack) {
            return stack.is(ConventionalItemTags.SHOVELS);
        }

        @Override
        protected boolean canDigImpl(ItemStack stack) {
            return isImpl(stack);
        }

        @Override
        protected boolean canHarvestImpl(ItemStack stack) {
            return isImpl(stack);
        }

        @Override
        protected boolean canCarveImpl(ItemStack stack) {
            return isImpl(stack);
        }

        @Override
        protected boolean canDisarmImpl(ItemStack stack) {
            return isImpl(stack);
        }
    }
}
