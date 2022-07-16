package net.dodogang.crumbs.inventory;

import net.dodogang.ash.gui.api.MenuTypeBatch;
import net.dodogang.crumbs.Crumbs;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class CrumbsMenuTypes {
    private static final MenuTypeBatch MENU_TYPES = MenuTypeBatch.create(Crumbs.MOD_ID);

    public static final Supplier<MenuType<CarpentryTableMenu>> CARPENTRY_TABLE = MENU_TYPES.add(
            "carpentry_table",
            CarpentryTableMenu::new
    );

    public static void register() {
        MENU_TYPES.register();
    }
}
