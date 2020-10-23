package net.dodogang.crumbs.block;

import java.util.Arrays;

import net.minecraft.block.Block;

public class CrumbsBlock {
    private static CrumbsBlock[] ALL = new CrumbsBlock[]{};

    private String id;
    private Block block;

    public CrumbsBlock(String id, Block block) {
        this.id = id;
        this.block = block;

        ALL = Arrays.copyOf(ALL, ALL.length + 1);
        ALL[ALL.length - 1] = this;
    }

    public String getId() {
        return id;
    }
    public Block getBlock() {
        return block;
    }

    public static CrumbsBlock[] getAll() {
        return ALL;
    }
}
