package me.bjtmastermind.raylibtest.blocks;

import me.bjtmastermind.raylibtest.base_blocks.Block;
import me.bjtmastermind.raylibtest.enums.Textures;

public class IceBlock extends Block {
    private final int id = 6;

    public IceBlock() {
        super(Textures.ICE_BLOCK);
    }

    public int getId() {
        return this.id;
    }
}
