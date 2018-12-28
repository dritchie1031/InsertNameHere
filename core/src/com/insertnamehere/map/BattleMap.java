/*
    Wrapper class for Tile array that serves as the map for a battle
 */
package com.insertnamehere.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Random;

public class BattleMap
{
    private Tile[][] tiles;
    private HashMap<TileType, Texture> tileTextures; // placed tile textures in BattleMap to clean up the core class

    // arguments: x dimension and y dimension of the BattleMap
    public BattleMap(int xdim, int ydim)
    {
        tiles = new Tile[xdim][ydim];
        initTiles(xdim, ydim);
    }

    // TODO: Add other tile type functionality
    private void initTiles(int xdim, int ydim)
    {	Random ran = new Random();
    	// randomizing the placement of the tiles
		// this will eventually be replaced by an algorithm that takes a seed and some parameters
        for (int i = 0; i < xdim; i++)
        {
            for (int j = 0; j < ydim; j++)
            {
            	TileType newType;
                int rand = ran.nextInt(3);
				switch(rand) {
					case 0:
						newType = TileType.GRASS1;
						break;
					case 1:
						newType = TileType.GRASS2;
						break;
					case 2:
						newType = TileType.GRASSFLOWER;
						break;
					default:
						newType = TileType.GRASS1;
				}
                tiles[i][j] = new Tile(newType, i, j);
            }
        }

        // adding the textures to a hashmap instead of attaching a texture to each tile (saves space)
        tileTextures = new HashMap<TileType, Texture>();
        tileTextures.put(TileType.GRASS1, new Texture(Gdx.files.internal("grass0-dirt-mix_1.png")));
        tileTextures.put(TileType.GRASS2, new Texture(Gdx.files.internal("grass0-dirt-mix_2.png")));
        tileTextures.put(TileType.GRASSFLOWER, new Texture(Gdx.files.internal("grass_flowers_yellow_1_new.png")));
    }

    public Tile getTileAt(int x, int y)
    {
        return tiles[x][y];
    }

    // Drawing the map internally for BattleMap, to keep INHCore cleaner
    public void draw(SpriteBatch batch)
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

    public void dispose() {
		TileType[] mapKeys = tileTextures.keySet().toArray(new TileType[0]);
		for (int i = 0; i < mapKeys.length; i++)
		{
			tileTextures.remove(mapKeys[i]).dispose(); // simultaneously removing textures from the hash map and
														//	disposing of them
		}
	}
}