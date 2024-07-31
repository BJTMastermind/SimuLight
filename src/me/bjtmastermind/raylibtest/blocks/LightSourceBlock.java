package me.bjtmastermind.raylibtest.blocks;

import me.bjtmastermind.raylibtest.base_blocks.Block;
import me.bjtmastermind.raylibtest.enums.Textures;

public class LightSourceBlock extends Block {
    private final int id = 2;

    public LightSourceBlock() {
        super(Textures.LIGHT_SOURCE_BLOCK);
    }

    public int getId() {
        return this.id;
    }
}
