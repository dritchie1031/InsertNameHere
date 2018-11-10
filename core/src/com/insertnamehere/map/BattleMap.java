/*
    Wrapper class for Tile array that serves as the map for a battle
 */
package com.insertnamehere.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class BattleMap
{
    private Tile[][] tiles;

    // arguments: x dimension and y dimension of the BattleMap
    public BattleMap(int xdim, int ydim)
    {
        tiles = new Tile[xdim][ydim];
        initTiles(xdim, ydim);
    }

    // Currently initializes all tiles to Grassland
    // TODO: Add other tile type functionality
    private void initTiles(int xdim, int ydim)
    {
        for (int i = 0; i < xdim; i++)
        {
            for (int j = 0; j < ydim; j++)
            {
                tiles[i][j] = new Tile(TileType.GRASS, i, j);
            }
        }
    }

    public Tile getTileAt(int x, int y)
    {
        return tiles[x][y];
    }

    // Drawing the map internally for BattleMap, to keep INHCore cleaner
    public void draw(SpriteBatch batch, HashMap tileTextures)
    {
        for (int i = 0; i < tiles.length; i++)
        {
            for (int j = 0; j < tiles[0].length; j++)
            {
                TileType type = tiles[i][j].getType();
                float xpos = tiles[i][j].getXPos();
                float ypos = tiles[i][j].getYPos();
                batch.draw((Texture) tileTextures.get(type), xpos, ypos);
            }
        }
    }
}

