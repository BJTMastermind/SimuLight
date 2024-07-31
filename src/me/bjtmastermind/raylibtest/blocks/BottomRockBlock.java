package me.bjtmastermind.raylibtest.blocks;

import me.bjtmastermind.raylibtest.base_blocks.Block;
import me.bjtmastermind.raylibtest.enums.Textures;

public class BottomRockBlock extends Block {
    private final int id = 3;

    public BottomRockBlock() {
        super(Textures.BOTTOM_ROCK_BLOCK);
    }

    public int getId() {
        return this.id;
    }
}
