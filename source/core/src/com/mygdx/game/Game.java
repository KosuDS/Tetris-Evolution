package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.mygdx.modes.DarwinMode;
import com.mygdx.modes.Mode;

public class Game implements Screen {
	
	public int darwinModeId = 5234;
	
	private int actualModeId;
	private Mode actualMode;
	
	private int width;
	private int height;
	
	public Game(int width, int height){
		
		this.width = width;
		this.height = height;
	}
	
	public void update(float delta){
		
		actualMode.update(delta);
	}
	
	public void touchScreen(int x, int y){
		
		actualMode.checkEvents(x, y);
	}
	
	public void setMode(int modeId){
		
		if (modeId == darwinModeId){
			
			actualModeId = darwinModeId;
			actualMode = new DarwinMode();
		}
	}

	@Override
	public void render(float delta) {
		
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
