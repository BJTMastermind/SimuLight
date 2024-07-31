package me.bjtmastermind.raylibtest.enums;

import static com.raylib.Raylib.ImageFlipVertical;
import static com.raylib.Raylib.LoadImageFromTexture;
import static com.raylib.Raylib.UpdateTexture;

// ImageLoader: https://codeberg.org/glowiak/librlimg
import com.glowiak.librlimg.ImageLoader;

import com.raylib.Raylib.Image;
import com.raylib.Raylib.Rectangle;
import com.raylib.Raylib.Texture;

public enum Textures {
    VISUAL_LIGHT_0(0, 15),
    VISUAL_LIGHT_1(1, 15),
    VISUAL_LIGHT_2(2, 15),
    VISUAL_LIGHT_3(3, 15),
    VISUAL_LIGHT_4(4, 15),
    VISUAL_LIGHT_5(5, 15),
    VISUAL_LIGHT_6(6, 15),
    VISUAL_LIGHT_7(7, 15),
    VISUAL_LIGHT_8(8, 15),
    VISUAL_LIGHT_9(9, 15),
    VISUAL_LIGHT_10(10, 15),
    VISUAL_LIGHT_11(11, 15),
    VISUAL_LIGHT_12(12, 15),
    VISUAL_LIGHT_13(13, 15),
    VISUAL_LIGHT_14(14, 15),
    VISUAL_LIGHT_15(15, 15),
    LIGHT_SOURCE_BLOCK(0, 14),
    BOTTOM_ROCK_BLOCK(1, 14),
    ROCK_BLOCK(2, 14),
    GLASS_BLOCK(3, 14),
    ICE_BLOCK(4, 14);

    private int x;
    private int y;

    private Textures(int x, int y) {
        this.x = x * 16;
        this.y = y * 16;
    }

    public Rectangle getTextureLocation() {
        return new Rectangle().x(this.x).y(this.y).width(16).height(16);
    }

    public static Textures fromTextureLocation(int x, int y) {
        int searchY = y + (15 - (y * 2));
        for (Textures texture : Textures.values()) {
            System.out.println(texture.x+","+texture.y);
            if (texture.x == (x * 16) && texture.y == (searchY * 16)) {
                return texture;
            }
        }
        return null;
    }

    public static Texture getAtlas() {
        Texture texture = ImageLoader.getTextureFromJar("/atlas.png");
        Image image = LoadImageFromTexture(texture);
        ImageFlipVertical(image);
        UpdateTexture(texture, image.data());
        return texture;
    }
}
