package com.insertnamehere.map;

import com.badlogic.gdx.math.Rectangle;

public class Tile
{
    private static final float HEIGHT = 32, WIDTH = 32; // Height and width of the Tile, in pixels
    private TileType tiletype;
    private Rectangle space;//Purpose: to decide whether an entity is in the Tile's space
                            //The rectangle is what deals with the position in pixels

    // arguments: x is the x position (the x axis array index) and y is the y position (y axis array index)
    public Tile(TileType t, int  x, int y)
    {
        tiletype = t;
        space = new Rectangle();
        space.set(x * WIDTH, y * HEIGHT, WIDTH, HEIGHT);  // Sets the dimensions and location (lower left
                                                                // corner) of the rectangle
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
