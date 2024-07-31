package me.bjtmastermind.raylibtest.utils;

public class Vector3i {
    private int[] values = new int[3];

    public int x() {
        return this.values[0];
    }

    public Vector3i x(int x) {
        this.values[0] = x;
        return this;
    }

    public int y() {
        return this.values[1];
    }

    public Vector3i y(int y) {
        this.values[1] = y;
        return this;
    }

    public int z() {
        return this.values[2];
    }

    public Vector3i z(int z) {
        this.values[2] = z;
        return this;
    }
}
