package com.insertnamehere.map;

import com.badlogic.gdx.math.Rectangle;

public class Tile
{
    private static final float HEIGHT = 32, WIDTH = 32;
    private TileType tiletype;
    private Rectangle space;//Purpose: to decide whether an entity is in the Tile's space

    public Tile(TileType t, int  x, int y)
    {
        tiletype = t;
        space = new Rectangle();
        space.set(x * 32, y * 32, WIDTH, HEIGHT);
    }

    public TileType getType()
    {
        return tiletype;
    }

    public Rectangle getRectangle()
    {
        return space;
    }

    public float getXPos()
    {
        return space.x;
    }

    public float getYPos()
    {
        return space.y;
    }
}
