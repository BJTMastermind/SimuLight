package me.bjtmastermind.raylibtest.blocks;

import me.bjtmastermind.raylibtest.base_blocks.Block;
import me.bjtmastermind.raylibtest.enums.Textures;

public class RockBlock extends Block {
    private final int id = 4;

    public RockBlock() {
        super(Textures.ROCK_BLOCK);
    }

    public int getId() {
        return this.id;
    }
}
