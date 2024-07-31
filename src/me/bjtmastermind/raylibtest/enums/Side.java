package me.bjtmastermind.raylibtest.enums;

public enum Side {
    SOUTH(4),
    NORTH(8),
    UP(12),
    DOWN(16),
    EAST(20),
    WEST(24);

    private int value;

    private Side(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
