package me.bjtmastermind.raylibtest;

import static com.raylib.Jaylib.BLACK;
import static com.raylib.Raylib.DrawText;
import static com.raylib.Raylib.GetFPS;

public class Debug {
    private float x;
    private float y;
    private float z;
    private float yaw;
    private float pitch;

    private int flooredX;
    private int flooredY;
    private int flooredZ;
    private int flooredChunkX;
    private int flooredChunkZ;

    private String facingName;
    private String facing;

    private void updateValues() {
        this.x = Camera.INSTANCE.getCamera()._position().x();
        this.y = Camera.INSTANCE.getCamera()._position().y();
        this.z = Camera.INSTANCE.getCamera()._position().z();
        this.yaw = Utils.wrap(Camera.INSTANCE.getCameraRotation().x());
        this.pitch = Utils.clamp(Camera.INSTANCE.getCameraRotation().y());

        this.flooredX = (int) Math.floor(Camera.INSTANCE.getCamera()._position().x());
        this.flooredY = (int) Math.floor(Camera.INSTANCE.getCamera()._position().y());
        this.flooredZ = (int) Math.floor(Camera.INSTANCE.getCamera()._position().z());
        this.flooredChunkX = (int) Math.floor(Camera.INSTANCE.getCamera()._position().x() / 16);
        this.flooredChunkZ = (int) Math.floor(Camera.INSTANCE.getCamera()._position().z() / 16);

        this.facingName = Utils.getFacingDirectionName(Utils.wrap(yaw));
        this.facing = Utils.getFacingDirection(Utils.wrap(yaw));
    }

    public void drawDebugScreen() {
        updateValues();

        DrawText(String.format("SimuLight 0.1.0", GetFPS()), 1, 0, 20, BLACK);
        if (Settings.showDebug) {
            // Left side of screen
            DrawText(String.format("FPS: %d", GetFPS()), 1, 20, 20, BLACK);
            DrawText(String.format("XYZ: %.3f / %.3f / %.3f", x, y, z, yaw, pitch), 1, 40, 20, BLACK);
            DrawText(String.format("Block Pos: %d, %d, %d [%d %d %d]", flooredX, flooredY, flooredZ, Math.floorMod(flooredX, 16), Math.floorMod(flooredY, 16), Math.floorMod(flooredZ, 16)), 1, 60, 20, BLACK);
            DrawText(String.format("Chunk Pos: %d, %d, %d", flooredChunkX, flooredY, flooredChunkZ), 1, 80, 20, BLACK);
            DrawText(String.format("Facing: %s (Towards %s) (%.1f / %.1f)", facingName, facing, yaw, pitch), 1, 100, 20, BLACK);
        }
        // Right side of screen
        DrawText(String.format("Simulation Running: %s", Settings.isSimulationRunning), 550, 0, 20, BLACK);
        DrawText(String.format("Simulation Delay: %ds", (int) Settings.simulationDelay), 594, 20, 20, BLACK);
        DrawText(String.format("Light Level: %d", Settings.lightLevel), 655, 40, 20, BLACK);
    }

    public void drawChunkBorders() {
        if (Settings.showChunkBorders) {
            Utils.drawChunkBorder(flooredChunkX, flooredChunkZ);
            Utils.drawGrid(16, 1.0f, flooredChunkX, Math.max(0f, Math.min(128f, (flooredY - 1))), flooredChunkZ);
        }
    }
}
