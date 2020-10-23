package net.dodogang.crumbs.block;

import java.util.ArrayList;

import net.minecraft.block.Block;

public class CrumbsBlock {
    private static ArrayList<CrumbsBlock> ALL = new ArrayList<>();

    private String id;
    private Block block;

    public CrumbsBlock(String id, Block block) {
        this.id = id;
        this.block = block;

        ALL.add(this);
    }

    public String getId() {
        return id;
    }
    public Block getBlock() {
        return block;
    }

    public static ArrayList<CrumbsBlock> getAll() {
        return ALL;
    }
}
