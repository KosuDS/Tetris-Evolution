package com.mygdx.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.tools.GifDecoder;

public class Splash implements Screen {

	TextureRegion textureCurrentFrame;
	private int idCurrentFrame = 0;
	
	SpriteBatch batch;
	Animation animation;
	
	private float deltaAccumulator = 0.0f;
	private float speedAnimation = 1/30f;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
		
		if (deltaAccumulator > speedAnimation){
			
			textureCurrentFrame = animation.getKeyFrame(idCurrentFrame, true); 
			
	        batch.begin();
	        batch.draw(textureCurrentFrame, 0, 0);          
	        batch.end();
	        
	        deltaAccumulator = deltaAccumulator - speedAnimation;
		}
		
		deltaAccumulator += delta;
	}

	@Override
	public void resize(int width, int height) {

		
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("my-gif-anumation.gif").read());

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