package me.bjtmastermind.raylibtest.blocks;

import me.bjtmastermind.raylibtest.base_blocks.Block;
import me.bjtmastermind.raylibtest.enums.Textures;

public class GlassBlock extends Block {
    private final int id = 5;

    public GlassBlock() {
        super(Textures.GLASS_BLOCK);
    }

    public int getId() {
        return this.id;
    }
}
