package me.bjtmastermind.raylibtest.interfaces;

import com.raylib.Raylib.Model;

public interface IBlock {
    public void draw(int x, int y, int z);
    public Model getModel();
}
