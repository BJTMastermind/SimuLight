package me.bjtmastermind.raylibtest.enums;

import me.bjtmastermind.raylibtest.blocks.*;
import me.bjtmastermind.raylibtest.interfaces.IBlock;

public enum BlockType {
    VISUAL_LIGHT(1, new VisualLightBlock()),
    LIGHT_SOURCE(2, new LightSourceBlock()),
    BOTTOM_ROCK(3, new BottomRockBlock()),
    ROCK(4, new RockBlock()),
    GLASS(5, new GlassBlock()),
    ICE(6, new IceBlock());

    private int id;
    private IBlock block;

    private BlockType(int id, IBlock block) {
        this.id = id;
        this.block = block;
    }

    public int getId() {
        return this.id;
    }

    public IBlock getBlock() {
        return this.block;
    }

    public BlockType fromId(int id) {
        for (BlockType type : BlockType.values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        return null;
    }
}
