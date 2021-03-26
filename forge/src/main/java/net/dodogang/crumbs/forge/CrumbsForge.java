package net.dodogang.crumbs.forge;

import com.mojang.datafixers.util.Function5;
import net.dodogang.crumbs.Crumbs;
import net.dodogang.crumbs.client.forge.CrumbsClientForge;
import net.dodogang.crumbs.platform.AbstractPlatform;
import net.dodogang.plume.ash.forge.ModEventBus;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Crumbs.MOD_ID)
public class CrumbsForge implements AbstractPlatform {
    public CrumbsForge() {
        ModEventBus.registerModEventBus(Crumbs.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        Crumbs.initialize(this);

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> CrumbsClientForge::new);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    public void setup(FMLCommonSetupEvent event) {
        Crumbs.setup();
    }

    @Override
    public void registerOnRightClickBlockHandler(Function5<PlayerEntity, World, Hand, BlockPos, Direction, ActionResult> event) {
        MinecraftForge.EVENT_BUS.<PlayerInteractEvent.RightClickBlock>addListener(e -> {
            if (!e.getPlayer().isSpectator()) {
                e.setCancellationResult(event.apply(e.getPlayer(), e.getWorld(), e.getHand(), e.getPos(), e.getFace()));
            }
        });
    }

    @Override
    public boolean isAxe(ItemStack stack) {
        return stack.getItem().getToolTypes(stack).contains(ToolType.AXE);
    }
}
