package me.bjtmastermind.raylibtest.enums;

public enum LightLevels {
    LEVEL_0(0, Textures.VISUAL_LIGHT_0),
    LEVEL_1(1, Textures.VISUAL_LIGHT_1),
    LEVEL_2(2, Textures.VISUAL_LIGHT_2),
    LEVEL_3(3, Textures.VISUAL_LIGHT_3),
    LEVEL_4(4, Textures.VISUAL_LIGHT_4),
    LEVEL_5(5, Textures.VISUAL_LIGHT_5),
    LEVEL_6(6, Textures.VISUAL_LIGHT_6),
    LEVEL_7(7, Textures.VISUAL_LIGHT_7),
    LEVEL_8(8, Textures.VISUAL_LIGHT_8),
    LEVEL_9(9, Textures.VISUAL_LIGHT_9),
    LEVEL_10(10, Textures.VISUAL_LIGHT_10),
    LEVEL_11(11, Textures.VISUAL_LIGHT_11),
    LEVEL_12(12, Textures.VISUAL_LIGHT_12),
    LEVEL_13(13, Textures.VISUAL_LIGHT_13),
    LEVEL_14(14, Textures.VISUAL_LIGHT_14),
    LEVEL_15(15, Textures.VISUAL_LIGHT_15);

    private int level;
    private Textures texture;

    private LightLevels(int level, Textures texture) {
        this.level = level;
        this.texture = texture;
    }

    public int getLevel() {
        return this.level;
    }

    public Textures getTexture() {
        return this.texture;
    }

    public static LightLevels fromLevel(int level) {
        for (LightLevels levels : LightLevels.values()) {
            if (levels.getLevel() == level) {
                return levels;
            }
        }
        return null;
    }
}
