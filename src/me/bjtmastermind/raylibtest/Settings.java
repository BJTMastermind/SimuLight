package me.bjtmastermind.raylibtest;

import com.raylib.Raylib;

public class Settings {
    static boolean isPaused = false;
    static boolean isSimulationRunning = false;
    static boolean showDebug = false;
    static boolean showChunkBorders = false;
    static int sprintMultiplier = 1;
    static int lightLevel = 15;
    static double simulationDelay = 0; // 0.0 = real-time light spread, 10.0 = really slow light spread

    // Key Binds
    static final int MOVE_FORWARD = Raylib.KEY_W;
    static final int MOVE_LEFT = Raylib.KEY_A;
    static final int MOVE_BACK = Raylib.KEY_S;
    static final int MOVE_RIGHT = Raylib.KEY_D;
    static final int MOVE_UP = Raylib.KEY_SPACE;
    static final int MOVE_DOWN = Raylib.KEY_LEFT_SHIFT;
    static final int RUN_SIM_TOGGLE = Raylib.KEY_T;
    static final int RESET_SIM = Raylib.KEY_R;
    static final int INCREASE_SIM_SPEED = Raylib.KEY_RIGHT;
    static final int DECREASE_SIM_SPEED = Raylib.KEY_LEFT;
    static final int INCREASE_LIGHT_LEVEL = Raylib.KEY_RIGHT_BRACKET;
    static final int DECREASE_LIGHT_LEVEL = Raylib.KEY_LEFT_BRACKET;
}
