package ru.gb;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import org.graalvm.compiler.core.target.Backend;

import java.awt.Image;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("ship.png");


	}

	@Override
	public void render () {
		ScreenUtils.clear(0.4f, 0.24f, 051f, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
