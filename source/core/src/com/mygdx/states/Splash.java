package com.mygdx.states;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.tools.GifDecoder;

public class Splash implements Screen {
	
	private final static int width = Gdx.graphics.getWidth();
	private final static int height = Gdx.graphics.getHeight();

	private TextureRegion textureCurrentFrame;
	
	private final SpriteBatch batch = new SpriteBatch();;
	private final Animation animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("res/img/splash.gif").read());;
	
	private float deltaAccumulator = 0.0f;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
        if (animation.isAnimationFinished(deltaAccumulator)){
        	((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
        	
        } else {
    		deltaAccumulator += delta;
    		textureCurrentFrame = animation.getKeyFrame(deltaAccumulator, true); 
        }
		
        batch.begin();
        batch.draw(textureCurrentFrame, 0, 0, width, height);
        batch.end();
        
	}

	@Override
	public void resize(int width, int height) {

		
	}

	@Override
	public void show() {

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