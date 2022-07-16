package net.dodogang.crumbs.inventory;

import net.dodogang.crumbs.block.CrumbsBlocks;
import net.dodogang.crumbs.item.crafting.CarpentryTableRecipe;
import net.dodogang.crumbs.item.crafting.CrumbsRecipeTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class CarpentryTableMenu extends AbstractContainerMenu {
    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex;
    private final Level level;
    private List<CarpentryTableRecipe> recipes;
    private ItemStack input;
    long lastSoundTime;
    final Slot inputSlot;
    final Slot resultSlot;
    Runnable slotUpdateListener;
    public final Container container;
    final ResultContainer resultContainer;

    public CarpentryTableMenu(int i, Inventory inventory) {
        this(i, inventory, ContainerLevelAccess.NULL);
    }

    public CarpentryTableMenu(int id, Inventory inventory, ContainerLevelAccess access) {
        super(CrumbsMenuTypes.CARPENTRY_TABLE.get(), id);
        this.selectedRecipeIndex = DataSlot.standalone();
        this.recipes = new ArrayList<>();
        this.input = ItemStack.EMPTY;
        this.slotUpdateListener = () -> {};
        this.container = new SimpleContainer(1) {
            @Override
            public void setChanged() {
                super.setChanged();
                CarpentryTableMenu.this.slotsChanged(this);
                CarpentryTableMenu.this.slotUpdateListener.run();
            }
        };
        this.resultContainer = new ResultContainer();
        this.access = access;
        this.level = inventory.player.level;
        this.inputSlot = this.addSlot(new Slot(this.container, 0, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 143, 33) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level, player, stack.getCount());
                CarpentryTableMenu.this.resultContainer.awardUsedRecipes(player);
                ItemStack newInputStack = CarpentryTableMenu.this.inputSlot.remove(1);
                if (!newInputStack.isEmpty()) {
                    CarpentryTableMenu.this.setupResultSlot();
                }

                access.execute((level, blockPos) -> {
                    long gameTime = level.getGameTime();
                    if (CarpentryTableMenu.this.lastSoundTime != gameTime) {
                        level.playSound(
                                null, blockPos,
                                SoundEvents.UI_STONECUTTER_TAKE_RESULT,
                                SoundSource.BLOCKS,
                                1.0f, 1.0f
                        );
                        CarpentryTableMenu.this.lastSoundTime = gameTime;
                    }
                });
                super.onTake(player, stack);
            }
        });

        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inventory, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }

        for (int j = 0; j < 9; ++j) {
            this.addSlot(new Slot(inventory, j, 8 + j * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }

    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public List<CarpentryTableRecipe> getRecipes() {
        return this.recipes;
    }

    public int getNumRecipes() {
        return this.recipes.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, CrumbsBlocks.CARPENTRY_TABLE.get());
    }

    @Override
    public boolean clickMenuButton(Player player, int i) {
        if (this.isValidRecipeIndex(i)) {
            this.selectedRecipeIndex.set(i);
            this.setupResultSlot();
        }

        return true;
    }

    private boolean isValidRecipeIndex(int i) {
        return i >= 0 && i < this.recipes.size();
    }

    public void slotsChanged(Container container) {
        ItemStack stack = this.inputSlot.getItem();
        if (!stack.is(this.input.getItem())) {
            this.input = stack.copy();
            this.setupRecipeList(container, stack);
        }
    }

    private void setupRecipeList(Container container, ItemStack stack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            this.recipes = this.level.getRecipeManager().getRecipesFor(
                    CrumbsRecipeTypes.CARPENTRY_TABLE.get(),
                    container,
                    this.level
            );
        }
    }

    private void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            CarpentryTableRecipe recipe = this.recipes.get(this.selectedRecipeIndex.get());
            this.resultContainer.setRecipeUsed(recipe);
            this.resultSlot.set(recipe.assemble(this.container));
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    public void registerUpdateListener(Runnable runnable) {
        this.slotUpdateListener = runnable;
    }

    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(i);
        if (slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            Item slotItem = slotStack.getItem();
            stack = slotStack.copy();
            if (i == 1) {
                slotItem.onCraftedBy(slotStack, player.level, player);
                if (!this.moveItemStackTo(slotStack, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(slotStack, stack);;
            } else if (i == 0) {
                if (!this.moveItemStackTo(slotStack, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(CrumbsRecipeTypes.CARPENTRY_TABLE.get(), new SimpleContainer(slotStack), this.level).isPresent()) {
                if (!this.moveItemStackTo(slotStack, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (i >= 2 && i < 29) {
                if (!this.moveItemStackTo(slotStack, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (i >= 29 && i < 38 && !this.moveItemStackTo(slotStack, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (slotStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (slotStack.getCount() == stack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, slotStack);
            this.broadcastChanges();
        }
        return stack;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((level, blockPos) -> {
            this.clearContainer(player, this.container);
        });
    }
}
