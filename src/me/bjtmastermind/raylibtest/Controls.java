package me.bjtmastermind.raylibtest;

import static com.raylib.Raylib.IsKeyDown;
import static com.raylib.Raylib.IsKeyReleased;
import static com.raylib.Raylib.KEY_ESCAPE;
import static com.raylib.Raylib.KEY_F3;
import static com.raylib.Raylib.KEY_G;
import static com.raylib.Raylib.KEY_LEFT_CONTROL;

public class Controls {

    public void updateControls() {
        sprint();
        pauseSim();
        toggleDebug();
        toggleChunkBorders();
        toggleSimulationRunningState();
    }

    private void sprint() {
        if (IsKeyDown(KEY_LEFT_CONTROL)) {
            Settings.sprintMultiplier = 5;
            Camera.INSTANCE.getCamera().fovy(75);
        } else {
            Settings.sprintMultiplier = 1;
            Camera.INSTANCE.getCamera().fovy(70);
        }
    }

    private void pauseSim() {
        if (IsKeyReleased(KEY_ESCAPE)) {
            Settings.isPaused = !Settings.isPaused;
        }
    }

    private void toggleDebug() {
        if (IsKeyReleased(KEY_F3)) {
            Settings.showDebug = !Settings.showDebug;
        }
    }

    private void toggleChunkBorders() {
        if (IsKeyDown(KEY_F3) && IsKeyReleased(KEY_G)) {
            Settings.showChunkBorders = !Settings.showChunkBorders;
        }
    }

    private void toggleSimulationRunningState() {
        if (IsKeyReleased(Settings.RUN_SIM_TOGGLE)) {
            Settings.isSimulationRunning = !Settings.isSimulationRunning;
        }
    }
}
