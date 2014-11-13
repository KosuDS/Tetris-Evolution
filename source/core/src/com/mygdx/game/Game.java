package com.mygdx.game;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.modes.DarwinMode;
import com.mygdx.modes.Mode;

public class Game implements Screen {

	private Mode actualMode;
	
	private SpriteBatch batch;
	
	private Texture texturePack;
	private Map<Integer, TextureRegion> textureBlocks;
	
	public Game(Mode mode){
		setMode(mode);
	}

	public void update(float delta){
		
		if (Gdx.input.justTouched()) {
			touchScreen(Gdx.input.getX(), Gdx.input.getY());
		}
		
		actualMode.update(delta);
	}
	
	public void touchScreen(int x, int y){
		
		actualMode.checkEvents(x, y);
	}
	
	public void setMode(Mode mode){
			
		actualMode = mode;
	}

	@Override
	public void render(float delta) {
		
		update(delta);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		actualMode.draw(batch, textureBlocks);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		texturePack = new Texture(Gdx.files.internal("res/img/textureSet.png"));
		textureBlocks = new HashMap<Integer, TextureRegion>();
		
		for (int column = 0; column < (int) texturePack.getWidth() / 32; column++) {
			textureBlocks.put(column, new TextureRegion(texturePack, column * 32, 0, 32, 32));
		}

	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
	}
}
