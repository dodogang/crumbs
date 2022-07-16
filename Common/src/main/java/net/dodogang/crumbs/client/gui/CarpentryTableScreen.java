package net.dodogang.crumbs.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.dodogang.crumbs.inventory.CarpentryTableMenu;
import net.dodogang.crumbs.item.crafting.CarpentryTableRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;

public class CarpentryTableScreen extends AbstractContainerScreen<CarpentryTableMenu> {
    private static final ResourceLocation BG_LOCATION = new ResourceLocation("textures/gui/container/stonecutter.png");

    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;

    public CarpentryTableScreen(CarpentryTableMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        menu.registerUpdateListener(this::containerChanged);
        --this.titleLabelY;
    }

    @Override
    public void render(PoseStack poseStack, int i, int j, float f) {
        super.render(poseStack, i, j, f);
        this.renderTooltip(poseStack, i, j);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float f, int i, int j) {
        this.renderBackground(poseStack);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, BG_LOCATION);
        this.blit(poseStack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        this.blit(
                poseStack,
                this.leftPos + 119,
                this.topPos + 15 + (int)(41.0f * this.scrollOffs),
                176 + (this.isScrollBarActive() ? 0 : 12),
                0,
                12,
                15
        );
        this.renderButtons(poseStack, i, j, this.leftPos + 52, this.topPos + 14, this.startIndex + 12);
        this.renderRecipes(this.leftPos + 52, this.topPos + 14, this.startIndex + 12);
    }

    @Override
    protected void renderTooltip(PoseStack poseStack, int i, int j) {
        super.renderTooltip(poseStack, i, j);
        if (this.displayRecipes) {
            int k = this.leftPos + 52;
            int l = this.topPos + 14;
            int m = this.startIndex + 12;
            List<CarpentryTableRecipe> recipes = this.menu.getRecipes();

            for (int n = this.startIndex; n < m && n < this.menu.getNumRecipes(); ++n) {
                int o = n - this.startIndex;
                int p = k + o % 4 * 16;
                int q = l + o / 4 * 18 + 2;
                if (i >= p && i < p + 16 && j >= q && j < q + 18) {
                    this.renderTooltip(poseStack, recipes.get(n).getResultItem(), i, j);
                }
            }
        }
    }

    private void renderButtons(PoseStack poseStack, int i, int j, int k, int l, int m) {
        for (int n = this.startIndex; n < m && n < this.menu.getNumRecipes(); ++n) {
            int o = n - this.startIndex;
            int p = k + o % 4 * 16;
            int q = o / 4;
            int r = l + q * 18 + 2;
            int s = this.imageHeight;
            if (n == this.menu.getSelectedRecipeIndex()){
                s += 18;
            } else if (i >= p && j >= r && i < p + 16 && j < r + 18) {
                s += 36;
            }
            this.blit(poseStack, p, r - 1, 0, s, 16, 18);
        }
    }

    private void renderRecipes(int i, int j, int k) {
        List<CarpentryTableRecipe> recipes = this.menu.getRecipes();

        for (int l = this.startIndex; l < k && l < this.menu.getNumRecipes(); ++l) {
            int m = l - this.startIndex;
            int n = i + m % 4 * 16;
            int o = m / 4;
            int p = j + o * 18 + 2;
            this.minecraft.getItemRenderer().renderAndDecorateItem(recipes.get(l).getResultItem(), n, p);
        }
    }

    @Override
    public boolean mouseClicked(double d, double e, int i) {
        this.scrolling = false;
        if (this.displayRecipes) {
            int j = this.leftPos + 52;
            int k = this.topPos + 14;
            int l = this.startIndex + 12;

            for (int m = this.startIndex; m < l; ++m) {
                int n = m - this.startIndex;
                double f = d - (j + n % 4 * 16);
                double g = e - (k + n / 4 * 18);
                if (f >= 0.0 && g >= 0.0 && f < 16.0 && g < 18.0 && this.menu.clickMenuButton(this.minecraft.player, m)) {
                    Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0f));
                    this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, m);
                    return true;
                }
            }

            j = this.leftPos + 119;
            k = this.topPos + 9;
            if (d >= j && d < j + 12 && e >= k && e < k + 54) {
                this.scrolling = true;
            }
        }

        return super.mouseClicked(d, e, i);
    }

    @Override
    public boolean mouseDragged(double d, double e, int i, double f, double g) {
        if (this.scrolling && this.isScrollBarActive()) {
            int j = this.topPos + 14;
            int k = j + 54;
            this.scrollOffs = (float) ((e - j - 7.5f) / ((k - j) - 15.0f));
            this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0f, 1.0f);
            this.startIndex = (int) (((this.scrollOffs * this.getOffscreenRows()) + 0.5) * 4);
            return true;
        } else {
            return super.mouseDragged(d, e, i, f, g);
        }
    }

    @Override
    public boolean mouseScrolled(double d, double e, double f) {
        if (this.isScrollBarActive()) {
            int i = this.getOffscreenRows();
            float g = (float) f / i;
            this.scrollOffs = Mth.clamp(this.scrollOffs - g, 0.0f, 1.0f);
            this.startIndex = (int) (((this.scrollOffs * i) + 0.5) * 4);
        }
        return true;
    }

    private boolean isScrollBarActive() {
        return this.displayRecipes && this.menu.getNumRecipes() > 12;
    }

    protected int getOffscreenRows() {
        return this.menu.getNumRecipes() + 4 - 1;
    }

    private void containerChanged() {
        this.displayRecipes = this.menu.hasInputItem();
        if (!this.displayRecipes) {
            this.scrollOffs = 0.0f;
            this.startIndex = 0;
        }
    }
}
