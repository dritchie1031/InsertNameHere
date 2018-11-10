package com.insertnamehere;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.insertnamehere.map.BattleMap;
import com.insertnamehere.map.TileType;

import java.util.HashMap;

public class INHCore extends ApplicationAdapter
{
    private SpriteBatch batch;
    private HashMap<TileType, Texture> tileTextures;
	private BattleMap map;
	private OrthographicCamera camera;

	
	@Override
	public void create ()
	{
		batch = new SpriteBatch();
		map = new BattleMap(20,10);
		tileTextures = new HashMap<TileType, Texture>();
		tileTextures.put(TileType.GRASS, new Texture(Gdx.files.internal("grass0-dirt-mix_1.png")));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 320, 320);
	}

	@Override
	public void render ()
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		map.draw(batch, tileTextures);
		batch.end();
	}
	
	@Override
	public void dispose ()
	{
		batch.dispose();
		// Disposing of all of the map sprites. This code is a mess right now
        // TODO: Clean this up
		TileType[] mapKeys = tileTextures.keySet().toArray(new TileType[0]);
		for (int i = 0; i < mapKeys.length; i++)
        {
            tileTextures.remove(mapKeys[i]).dispose(); // simultaneously removing textures from the hash map and
														//	disposing of them
        }
	}
}
