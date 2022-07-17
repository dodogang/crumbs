package net.dodogang.ash.tag.impl;

import net.dodogang.ash.tag.api.Tools;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ToolActions;

public class ToolsImpl {
    public static class AxeImpl extends Tools.Axe {
        @Override
        protected boolean isImpl(ItemStack stack) {
            return ToolActions.DEFAULT_AXE_ACTIONS.stream().allMatch(stack::canPerformAction);
        }

        @Override
        protected boolean canDigImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.AXE_DIG);
        }

        @Override
        protected boolean canStripImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.AXE_STRIP);
        }

        @Override
        protected boolean canScrapeImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.AXE_SCRAPE);
        }

        @Override
        protected boolean canWaxOffImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.AXE_WAX_OFF);
        }
    }

    public static class HoeImpl extends Tools.Hoe {
        @Override
        protected boolean isImpl(ItemStack stack) {
            return ToolActions.DEFAULT_HOE_ACTIONS.stream().allMatch(stack::canPerformAction);
        }

        @Override
        protected boolean canDigImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.HOE_DIG);
        }

        @Override
        protected boolean canTillImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.HOE_TILL);
        }
    }

    public static class ShovelImpl extends Tools.Shovel {
        @Override
        protected boolean isImpl(ItemStack stack) {
            return ToolActions.DEFAULT_SHOVEL_ACTIONS.stream().allMatch(stack::canPerformAction);
        }

        @Override
        protected boolean canDigImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.SHOVEL_DIG);
        }

        @Override
        protected boolean canFlattenImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.SHOVEL_FLATTEN);
        }
    }

    public static class PickaxeImpl extends Tools.Pickaxe {
        @Override
        protected boolean isImpl(ItemStack stack) {
            return ToolActions.DEFAULT_PICKAXE_ACTIONS.stream().allMatch(stack::canPerformAction);
        }

        @Override
        protected boolean canDigImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.PICKAXE_DIG);
        }
    }

    public static class SwordImpl extends Tools.Sword {
        @Override
        protected boolean isImpl(ItemStack stack) {
            return ToolActions.DEFAULT_SWORD_ACTIONS.stream().allMatch(stack::canPerformAction);
        }

        @Override
        protected boolean canDigImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.SHOVEL_DIG);
        }

        @Override
        protected boolean canSweepImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.SWORD_SWEEP);
        }
    }

    public static class ShearsImpl extends Tools.Shears {
        @Override
        protected boolean isImpl(ItemStack stack) {
            return ToolActions.DEFAULT_SHEARS_ACTIONS.stream().allMatch(stack::canPerformAction);
        }

        @Override
        protected boolean canDigImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.SHEARS_DIG);
        }

        @Override
        protected boolean canHarvestImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.SHEARS_HARVEST);
        }

        @Override
        protected boolean canCarveImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.SHEARS_CARVE);
        }

        @Override
        protected boolean canDisarmImpl(ItemStack stack) {
            return stack.canPerformAction(ToolActions.SHEARS_DISARM);
        }
    }
}
