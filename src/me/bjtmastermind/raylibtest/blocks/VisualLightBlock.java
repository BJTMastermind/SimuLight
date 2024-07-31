package me.bjtmastermind.raylibtest.blocks;

import me.bjtmastermind.raylibtest.base_blocks.Block;
import me.bjtmastermind.raylibtest.enums.LightLevels;
import me.bjtmastermind.raylibtest.enums.Textures;

public class VisualLightBlock extends Block {
    private final int id = 1;

    public VisualLightBlock() {
        super(Textures.VISUAL_LIGHT_0);
    }

    public VisualLightBlock(LightLevels level) {
        super(level.getTexture());
    }

    public int getId() {
        return this.id;
    }
}
