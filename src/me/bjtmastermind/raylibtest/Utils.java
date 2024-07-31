package me.bjtmastermind.raylibtest;

import static com.raylib.Jaylib.GRAY;
import static com.raylib.Jaylib.RED;
import static com.raylib.Jaylib.WHITE;
import static com.raylib.Jaylib.YELLOW;
import static com.raylib.Raylib.DrawLine3D;

import java.util.ArrayList;

import com.raylib.Raylib.Vector3;

import me.bjtmastermind.raylibtest.utils.Vector4i;

public class Utils {

    public static float clamp(float value) {
        return Math.max(-90f, Math.min(90f, value));
    }

    public static float wrap(float value) {
        float rangeSize = 180 - -179.9f + 1;
        return ((value - -179.9f) % rangeSize + rangeSize) % rangeSize + -179.9f;
    }

    public static String getFacingDirectionName(float yaw) {
        if (yaw >= -44.9f && yaw <= 45f) {
            return "south";
        }
        if (yaw >= 45.1f && yaw <= 135f) {
            return "west";
        }
        if (yaw >= -135f && yaw <= -45.1f) {
            return "east";
        }
        return "north";
    }

    public static String getFacingDirection(float yaw) {
        if (yaw >= -44.9f && yaw <= 45f) {
            return "positive Z";
        }
        if (yaw >= 45.1f && yaw <= 135f) {
            return "negative X";
        }
        if (yaw >= -135f && yaw <= -45.1f) {
            return "positive X";
        }
        return "negative Z";
    }

    public static void drawGrid(int slices, float spacing, float chunkX, float posY, float chunkZ) {
        float posX = chunkX * 16;
        float posZ = chunkZ * 16;

        for (int i = -slices / 2; i <= slices / 2; i++) {
            DrawLine3D(new Vector3().x((posX + 8f) - spacing * slices / 2.0f).y(posY - 0.5f).z((posZ + 8f) + i * spacing),
                new Vector3().x((posX + 8f) + spacing * slices / 2.0f).y(posY - 0.5f).z((posZ + 8f) + i * spacing), WHITE);
            DrawLine3D(new Vector3().x((posX + 8f) + i * spacing).y(posY - 0.5f).z((posZ + 8f) - spacing * slices / 2.0f),
                new Vector3().x((posX + 8f) + i * spacing).y(posY - 0.5f).z((posZ + 8f) + spacing * slices / 2.0f), WHITE);
        }

        DrawLine3D(new Vector3().x((posX + 8f) - spacing * slices / 2.0f).y(posY - 0.5f).z((posZ + 8f) - spacing * slices / 2.0f),
            new Vector3().x((posX + 8f) + spacing * slices / 2.0f).y(posY - 0.5f).z((posZ + 8f) - spacing * slices / 2.0f ), GRAY);
        DrawLine3D(new Vector3().x((posX + 8f) - spacing * slices / 2.0f).y(posY - 0.5f).z((posZ + 8f) - spacing * slices / 2.0f ),
            new Vector3().x((posX + 8f) - spacing * slices / 2.0f).y(posY - 0.5f).z((posZ + 8f) + spacing * slices / 2.0f ), GRAY);
        DrawLine3D(new Vector3().x((posX + 8f) + spacing * slices / 2.0f).y(posY - 0.5f).z((posZ + 8f) + spacing * slices / 2.0f ),
            new Vector3().x((posX + 8f) - spacing * slices / 2.0f).y(posY - 0.5f).z((posZ + 8f) + spacing * slices / 2.0f ), GRAY);
        DrawLine3D(new Vector3().x((posX + 8f) + spacing * slices / 2.0f).y(posY - 0.5f).z((posZ + 8f) + spacing * slices / 2.0f ),
            new Vector3().x((posX + 8f) + spacing * slices / 2.0f).y(posY - 0.5f).z((posZ + 8f) - spacing * slices / 2.0f ), GRAY);
    }

    public static void drawChunkBorder(int chunkX, int chunkZ) {
        float posX = chunkX * 16;
        float posZ = chunkZ * 16;

        for (int i = -16 / 4; i <= 16 / 4; i++) {
            // X Walls Vertical
            DrawLine3D(new Vector3().x((posX + 4f) - 2 * 16 / 8.0f).y(-0.5f).z((posZ + 8f) + i * 16 / 8.0f),
                new Vector3().x((posX + 4f) - 2 * 16 / 8.0f).y(128.5f).z((posZ + 8f) + i * 16 / 8.0f), YELLOW);

            DrawLine3D(new Vector3().x((posX + 20f) - 2 * 16 / 8.0f).y(-0.5f).z((posZ + 8f) + i * 16 / 8.0f),
                new Vector3().x((posX + 20f) - 2 * 16 / 8.0f).y(128.5f).z((posZ + 8f) + i * 16 / 8.0f), YELLOW);

            // Z Walls Vertical
            DrawLine3D(new Vector3().x((posX + 8f) - i * 16 / 8.0f).y(-0.5f).z((posZ + 12f) + 2 * 16 / 8.0f),
                new Vector3().x((posX + 8f) - i * 16 / 8.0f).y(128.5f).z((posZ + 12f) + 2 * 16 / 8.0f), YELLOW);

            DrawLine3D(new Vector3().x((posX + 8f) - i * 16 / 8.0f).y(-0.5f).z((posZ - 4f) + 2 * 16 / 8.0f),
                new Vector3().x((posX + 8f) - i * 16 / 8.0f).y(128.5f).z((posZ - 4f) + 2 * 16 / 8.0f), YELLOW);
        }

        for (int y = 0; y <= 129; y += 2) {
            // X Walls Horizontal
            DrawLine3D(new Vector3().x(posX).y(y - 0.5f).z((posZ + 8f) - 2 * 16 / 4.0f),
                new Vector3().x(posX).y(y - 0.5f).z((posZ + 8f) + 2 * 16 / 4.0f), YELLOW);

            DrawLine3D(new Vector3().x(posX + 16f).y(y - 0.5f).z((posZ + 8f) - 2 * 16 / 4.0f),
                new Vector3().x(posX + 16f).y(y - 0.5f).z((posZ + 8f) + 2 * 16 / 4.0f), YELLOW);
            // Z Walls Horizontal
            DrawLine3D(new Vector3().x((posX + 8f) - 2 * 16 / 4.0f).y(y - 0.5f).z(posZ),
                new Vector3().x((posX + 8f) + 2 * 16 / 4.0f).y(y - 0.5f).z(posZ), YELLOW);

            DrawLine3D(new Vector3().x((posX + 8f) - 2 * 16 / 4.0f).y(y - 0.5f).z(posZ + 16f),
                new Vector3().x((posX + 8f) + 2 * 16 / 4.0f).y(y - 0.5f).z(posZ + 16f), YELLOW);
        }

        DrawLine3D(new Vector3().x((posX + 8f) - 2 * 16 / 4.0f).y(-0.5f).z((posZ + 8f) - 2 * 16 / 4.0f),
            new Vector3().x((posX + 8f) - 2 * 16 / 4.0f).y(128.5f).z((posZ + 8f) - 2 * 16 / 4.0f ), RED);
        DrawLine3D(new Vector3().x(((posX + 8f) + 16f) - 2 * 16 / 4.0f).y(-0.5f).z((posZ + 8f) - 2 * 16 / 4.0f ),
            new Vector3().x(((posX + 8f) + 16f) - 2 * 16 / 4.0f).y(128.5f).z((posZ + 8f) - 2 * 16 / 4.0f ), RED);
        DrawLine3D(new Vector3().x((posX + 8f) - 2 * 16 /4.0f).y(-0.5f).z(((posZ + 8f) + 16f) - 2 * 16 / 4.0f ),
            new Vector3().x((posX + 8f) - 2 * 16 / 4.0f).y(128.5f).z(((posZ + 8f) + 16f) - 2 * 16 / 4.0f ), RED);
        DrawLine3D(new Vector3().x(((posX + 8f) + 16f) - 2 * 16 / 4.0f).y(-0.5f).z(((posZ + 8f) + 16f) - 2 * 16 / 4.0f ),
            new Vector3().x(((posX + 8f) + 16f) - 2 * 16 / 4.0f).y(128.5f).z(((posZ + 8f) + 16f) - 2 * 16 / 4.0f ), RED);
    }

    public static boolean listContainsVector4i(ArrayList<Vector4i> list, Vector4i findVec) {
        for (Vector4i vec : list) {
            if (vec.x() == findVec.x() && vec.y() == findVec.y() && vec.z() == findVec.z()) {
                return true;
            }
        }
        return false;
    }
}
