package com.mygdx.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.tools.GifDecoder;

public class Splash implements Screen {

	TextureRegion currentFrame;
	Batch batch;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
		
		
	}

	@Override
	public void resize(int width, int height) {

		
	}

	@Override
	public void show() {
		Animation anim = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("my-gif-anumation.gif").read());
		
		currentFrame = anim.getKeyFrame(1, true); 
        batch.begin();
        batch.draw(currentFrame, 0, 0);          
        batch.end();
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
