package me.bjtmastermind.raylibtest.base_blocks;

import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.DrawModel;
import static com.raylib.Raylib.GenMeshCube;
import static com.raylib.Raylib.LoadModelFromMesh;
import static com.raylib.Raylib.UpdateMeshBuffer;

import com.raylib.Jaylib.Vector3;
import com.raylib.Raylib.Mesh;
import com.raylib.Raylib.Model;
import com.raylib.Raylib.Rectangle;
import com.raylib.Raylib.Texture;

import me.bjtmastermind.raylibtest.enums.Side;
import me.bjtmastermind.raylibtest.enums.Textures;
import me.bjtmastermind.raylibtest.interfaces.IBlock;

public class Block implements IBlock {
    private Mesh blockMesh = GenMeshCube(1f, 1f, 1f);
    private Model block = LoadModelFromMesh(blockMesh);
    private final Texture atlas = Textures.getAtlas();

    public Block(Textures texture) {
        for (Side side : Side.values()) {
            applyTextureToSideOfMesh(block, texture.getTextureLocation(), atlas, side);
        }

        this.block.materials().maps().texture(atlas);

        // Update the mesh with the new UV coordinates
        UpdateMeshBuffer(block.meshes().position(0), 1, block.meshes().texcoords().position(0), block.meshes().vertexCount()*2*4, 0);
    }

    @Override
    public void draw(int x, int y, int z) {
        if (y < 0 || y > 128) {
            System.err.println("Can't place block outside of world bounds.");
            return;
        }

        DrawModel(this.block, new Vector3().x(x + 0.5f).y((float) y).z(z + 0.5f), 1f, WHITE);
    }

    @Override
    public Model getModel() {
        return this.block;
    }

    private void applyTextureToSideOfMesh(Model model, Rectangle sourceRec, Texture texture, Side side) {
        for (int i = side.getValue() - 4; i < side.getValue(); i++) {
            int index = i * 2;

            // Access the original UV coordinates
            float u = model.meshes().texcoords().get(index);
            float v = model.meshes().texcoords().get(index + 1);

            // Scale and translate the UV coordinates to use only the specified section of the texture
            model.meshes().texcoords().put(index, sourceRec.x() / texture.width() + u * (sourceRec.width() / texture.width()));
            model.meshes().texcoords().put(index + 1, sourceRec.y() / texture.height() + v * (sourceRec.height() / texture.height()));
        }
    }
}
