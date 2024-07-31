package me.bjtmastermind.raylibtest;

import static com.raylib.Jaylib.RED;
import static com.raylib.Jaylib.SKYBLUE;
import static com.raylib.Raylib.*;

import java.util.ArrayList;

import com.raylib.Raylib.Camera3D;

import me.bjtmastermind.raylibtest.enums.BlockType;
import me.bjtmastermind.raylibtest.enums.Textures;
import me.bjtmastermind.raylibtest.interfaces.IBlock;

public class Main {
    private static ArrayList<IBlock> blocks = new ArrayList<>();

    public static void main(String args[]) {
        // SetConfigFlags(FLAG_WINDOW_RESIZABLE); // To be enabled later after things are made to scale for this.
        InitWindow(800, 450, "SimuLight");
        SetExitKey(KEY_NULL);
        SetTargetFPS(60);

        Controls controls = new Controls();
        Camera cam = new Camera(0, 1, 0);
        Debug debug = new Debug();
        Simulation sim = new Simulation();

        while (!WindowShouldClose()) {
            controls.updateControls();

            Camera3D camera = cam.getCamera();

            cam.updateCamera();

            BeginDrawing();
            ClearBackground(SKYBLUE);
            BeginMode3D(camera);

            int x = 0;
            int z = 0;
            for (BlockType type : BlockType.values()) {
                if (x >= 16) {
                    x = 0;
                    z += 2;
                }

                type.getBlock().draw(x, 0, z);

                x += 2;
            }

            if (!Settings.isPaused) {
                sim.simulate();
            }

            debug.drawChunkBorders();

            EndMode3D();

            debug.drawDebugScreen();

            // Pause Screen
            if (Settings.isPaused) {
                ShowCursor();
                DrawText("Simulation Paused!", (GetScreenWidth() / 2) - (20 * 4), GetScreenHeight() / 2, 20, RED);
            } else {
                DisableCursor();
            }

            EndDrawing();
        }

        for (IBlock block : blocks) {
            UnloadModel(block.getModel());
        }

        UnloadTexture(Textures.getAtlas());

        CloseWindow();
    }
}
