package com.insertnamehere.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class Character
{
    protected Texture texture;
    public Character()
    {
        texture = new Texture(Gdx.files.internal("aragorn.png"));
    }

    public void draw(SpriteBatch batch)
    {
        batch.draw(texture, 1.0f, 1.0f);
    }

    public void dispose()
    {
        texture.dispose();
    }
}
