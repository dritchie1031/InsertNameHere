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
	private BattleMap map;
	private OrthographicCamera camera;

	
	@Override
	public void create ()
	{
		batch = new SpriteBatch();
		map = new BattleMap(20,10);
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
		map.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose ()
	{
		batch.dispose();
		// Disposing of all of the map sprites. This code is a mess right now
		// TODO: Clean this up
		map.dispose();
	}
}
