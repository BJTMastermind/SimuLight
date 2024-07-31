package me.bjtmastermind.raylibtest;

import static com.raylib.Raylib.GetTime;
import static com.raylib.Raylib.IsKeyReleased;

import java.util.ArrayList;
import java.util.HashMap;

import me.bjtmastermind.raylibtest.blocks.LightSourceBlock;
import me.bjtmastermind.raylibtest.blocks.VisualLightBlock;
import me.bjtmastermind.raylibtest.enums.LightLevels;
import me.bjtmastermind.raylibtest.utils.Vector3i;
import me.bjtmastermind.raylibtest.utils.Vector4i;

public class Simulation {
    public static Simulation INSTANCE;
    private int maxDistance = Settings.lightLevel - 1;
    private ArrayList<Vector4i> lightLocations = new ArrayList<>();
    private LightSourceBlock source = new LightSourceBlock();

    private HashMap<Integer, VisualLightBlock> lightBlocks = new HashMap<>() {{
        put(0, new VisualLightBlock(LightLevels.LEVEL_0));
        put(1, new VisualLightBlock(LightLevels.LEVEL_1));
        put(2, new VisualLightBlock(LightLevels.LEVEL_2));
        put(3, new VisualLightBlock(LightLevels.LEVEL_3));
        put(4, new VisualLightBlock(LightLevels.LEVEL_4));
        put(5, new VisualLightBlock(LightLevels.LEVEL_5));
        put(6, new VisualLightBlock(LightLevels.LEVEL_6));
        put(7, new VisualLightBlock(LightLevels.LEVEL_7));
        put(8, new VisualLightBlock(LightLevels.LEVEL_8));
        put(9, new VisualLightBlock(LightLevels.LEVEL_9));
        put(10, new VisualLightBlock(LightLevels.LEVEL_10));
        put(11, new VisualLightBlock(LightLevels.LEVEL_11));
        put(12, new VisualLightBlock(LightLevels.LEVEL_12));
        put(13, new VisualLightBlock(LightLevels.LEVEL_13));
        put(14, new VisualLightBlock(LightLevels.LEVEL_14));
        put(15, new VisualLightBlock(LightLevels.LEVEL_15));
    }};

    private double lastRan = GetTime();

    private Vector3i lightSource = new Vector3i().x(8).y(32).z(8);

    private int i = 0;
    private int x = lightSource.x() - maxDistance;
    private int y = lightSource.y() - maxDistance;
    private int z = lightSource.z() - maxDistance;
    private ArrayList<Vector3i> maxLightLocations = new ArrayList<>();

    public Simulation() {
        INSTANCE = this;
    }

    public void simulate() {
        resetSimulation();
        changeSimSpeed();
        changeLightLevel();

        source.draw(lightSource.x(), lightSource.y(), lightSource.z());

        if (Settings.isSimulationRunning && this.ready()) {
            this.runLightingSim();
        }

        for (Vector4i location : lightLocations) {
            lightBlocks.get(location.w()).draw(location.x(), location.y(), location.z());
        }
    }

    private void resetSimulation() {
        if (IsKeyReleased(Settings.RESET_SIM)) {
            int size = lightLocations.size();
            for (int i = 0; i < size; i++) {
                lightLocations.remove(0);
            }

            x = lightSource.x();
            y = lightSource.y();
            z = lightSource.z();
            maxLightLocations = new ArrayList<>();
        }
    }

    private void changeSimSpeed() {
        if (IsKeyReleased(Settings.INCREASE_SIM_SPEED)) {
            Settings.simulationDelay = Math.min(Settings.simulationDelay + 1.0, 10.0);
        }

        if (IsKeyReleased(Settings.DECREASE_SIM_SPEED)) {
            Settings.simulationDelay = Math.max(Settings.simulationDelay - 1.0, 0.0);
        }
    }

    private void changeLightLevel() {
        if (IsKeyReleased(Settings.INCREASE_LIGHT_LEVEL) && !Settings.isSimulationRunning) {
            Settings.lightLevel = Math.min(Settings.lightLevel + 1, 15);
        }

        if (IsKeyReleased(Settings.DECREASE_LIGHT_LEVEL) && !Settings.isSimulationRunning) {
            Settings.lightLevel = Math.max(Settings.lightLevel - 1, 0);
        }

        maxDistance = Settings.lightLevel - 1;
    }

    private void runLightingSim() {
        double now = GetTime();
        lastRan = now;

        if (lightLocations.isEmpty()) {
            calculateLighting();
        }
    }

    // private void calculateLightingControllable() {
    //     if (lightLocations.isEmpty()) {
    //         for (int dx = -maxDistance; dx <= maxDistance; dx++) {
    //             for (int dy = -maxDistance; dy <= maxDistance; dy++) {
    //                 int dz = maxDistance - Math.abs(dx) - Math.abs(dy);
    //                 if (dz >= 0) {
    //                     Vector3i location1 = new Vector3i().x(lightSource.x() + dx).y(lightSource.y() + dy).z(lightSource.z() + dz);
    //                     maxLightLocations.add(location1);

    //                     if (dz > 0) {
    //                         Vector3i location2 = new Vector3i().x(lightSource.x() + dx).y(lightSource.y() + dy).z(lightSource.z() - dz);
    //                         maxLightLocations.add(location2);
    //                     }
    //                 }
    //             }
    //         }
    //     }

    //     Vector3i location = maxLightLocations.get(i);
    //     int minX = Math.min(lightSource.x(), location.x());
    //     int minY = Math.min(lightSource.y(), location.y());
    //     int minZ = Math.min(lightSource.z(), location.z());
    //     int maxX = Math.max(lightSource.x(), location.x());
    //     int maxY = Math.max(lightSource.y(), location.y());
    //     int maxZ = Math.max(lightSource.z(), location.z());

    //     int distance = calculateTaxicabDistance(lightSource, new Vector3i().x(x).y(y).z(z));
    //     Vector4i vec = new Vector4i().x(x).y(y).z(z).w(Settings.lightLevel - distance);

    //     if (distance <= maxDistance && !Utils.listContainsVector4i(lightLocations, vec)) {
    //         lightLocations.add(vec);
    //     }

    //     incrementValues(minX, minY, minZ, maxX, maxY, maxZ);
    // }

    // private void incrementValues(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
    //     if (x == maxX) {
    //         x = minX;
    //         y++;

    //         if (y >= maxY) {
    //             y = minY;
    //             z++;

    //             if (z >= maxZ) {
    //                 z = minZ;
    //                 i++;
    //             }
    //         }
    //     } else {
    //         x++;
    //     }
    // }

    private void calculateLighting() {
        // Get outter most light locations
        for (int dx = -maxDistance; dx <= maxDistance; dx++) {
            for (int dy = -maxDistance; dy <= maxDistance; dy++) {
                int dz = maxDistance - Math.abs(dx) - Math.abs(dy);
                if (dz >= 0) {
                    Vector3i location1 = new Vector3i().x(lightSource.x() + dx).y(lightSource.y() + dy).z(lightSource.z() + dz);
                    maxLightLocations.add(location1);

                    if (dz > 0) {
                        Vector3i location2 = new Vector3i().x(lightSource.x() + dx).y(lightSource.y() + dy).z(lightSource.z() - dz);
                        maxLightLocations.add(location2);
                    }
                }
            }
        }

        // Fill shape in
        for (Vector3i location : maxLightLocations) {
            int minX = Math.min(lightSource.x(), location.x());
            int minY = Math.min(lightSource.y(), location.y());
            int minZ = Math.min(lightSource.z(), location.z());
            int maxX = Math.max(lightSource.x(), location.x());
            int maxY = Math.max(lightSource.y(), location.y());
            int maxZ = Math.max(lightSource.z(), location.z());

            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    for (int z = minZ; z <= maxZ; z++) {
                        int distance = calculateTaxicabDistance(lightSource, new Vector3i().x(x).y(y).z(z));
                        Vector4i vec = new Vector4i().x(x).y(y).z(z).w(Settings.lightLevel - distance);

                        if (distance <= maxDistance && !Utils.listContainsVector4i(lightLocations, vec)) {
                            lightLocations.add(vec);
                        }
                    }
                }
            }
        }
    }

    private int calculateTaxicabDistance(Vector3i pos1, Vector3i pos2) {
        int deltaX = Math.abs(pos1.x() - pos2.x());
        int deltaY = Math.abs(pos1.y() - pos2.y());
        int deltaZ = Math.abs(pos1.z() - pos2.z());

        return deltaX + deltaY + deltaZ;
    }

    private boolean ready() {
        // if (i == maxLightLocations.size()) {
            // return false;
        // }
        // double now = GetTime();
        // return now >= lastRan + Settings.simulationDelay;
        return true;
    }
}
