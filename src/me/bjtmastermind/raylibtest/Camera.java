package me.bjtmastermind.raylibtest;

import static com.raylib.Raylib.CAMERA_PERSPECTIVE;
import static com.raylib.Raylib.GetMouseDelta;
import static com.raylib.Raylib.IsKeyDown;
import static com.raylib.Raylib.UpdateCameraPro;

import com.raylib.Raylib.Camera3D;
import com.raylib.Raylib.Vector2;
import com.raylib.Raylib.Vector3;

public class Camera {
    public static Camera INSTANCE;
    private Camera3D camera;
    private Vector2 rotation;

    public Camera(float x, float y, float z) {
        camera = new Camera3D();
        camera._position(new Vector3().x(x + 0.5f).y(y).z(z + 0.5f));
        camera.target(new Vector3().x(x + 0.5f).y(y).z(z + 1.5f));
        camera.up(new Vector3().x(0).y(1).z(0));
        camera.fovy(70);
        camera.projection(CAMERA_PERSPECTIVE);

        rotation = new Vector2();

        INSTANCE = this;
    }

    public void updateCamera() {
        Vector3 mouseMotion = !Settings.isPaused ? new Vector3()
            // yaw
            .x(GetMouseDelta().x()*0.1f)
            // pitch
            .y(GetMouseDelta().y()*0.1f)
            // roll
            .z(0.0f)
        : new Vector3();

        rotation.x(rotation.x() + mouseMotion.x());
        rotation.y(rotation.y() + mouseMotion.y());

        UpdateCameraPro(camera, !Settings.isPaused ? new Vector3()
            // Move forward-backward
            .x((IsKeyDown(Settings.MOVE_FORWARD) ? 1.0f : 0.0f)*(0.05f * Settings.sprintMultiplier) - (IsKeyDown(Settings.MOVE_BACK) ? 1.0f : 0.0f)*(0.05f * Settings.sprintMultiplier))
            // Move right-left
            .y((IsKeyDown(Settings.MOVE_RIGHT) ? 1.0f : 0.0f)*(0.05f * Settings.sprintMultiplier) - (IsKeyDown(Settings.MOVE_LEFT) ? 1.0f : 0.0f)*(0.05f * Settings.sprintMultiplier))
            // Move up-down
            .z((IsKeyDown(Settings.MOVE_UP) ? 1.0f : 0.0f)*(0.1f * Settings.sprintMultiplier) - (IsKeyDown(Settings.MOVE_DOWN) ? 1.0f : 0.0f)*(0.1f * Settings.sprintMultiplier))
            : new Vector3(),
            mouseMotion,
            0
        );
    }

    public Camera3D getCamera() {
        return this.camera;
    }

    public Vector2 getCameraRotation() {
        return this.rotation;
    }
}
