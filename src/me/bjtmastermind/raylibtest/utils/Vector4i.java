package me.bjtmastermind.raylibtest.utils;

public class Vector4i {
    private int[] values = new int[4];

    public int x() {
        return this.values[0];
    }

    public Vector4i x(int x) {
        this.values[0] = x;
        return this;
    }

    public int y() {
        return this.values[1];
    }

    public Vector4i y(int y) {
        this.values[1] = y;
        return this;
    }

    public int z() {
        return this.values[2];
    }

    public Vector4i z(int z) {
        this.values[2] = z;
        return this;
    }

    public int w() {
        return this.values[3];
    }

    public Vector4i w(int w) {
        this.values[3] = w;
        return this;
    }
}
