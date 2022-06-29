package net.dodogang.crumbs;

import net.dodogang.crumbs.client.CrumbsClientForge;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(Crumbs.MOD_ID)
public class CrumbsForge {
    public CrumbsForge() {
        Crumbs.initialize();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> CrumbsClientForge::new);
    }
}
