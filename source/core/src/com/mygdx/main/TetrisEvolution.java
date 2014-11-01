package com.mygdx.main;

import com.badlogic.gdx.Game;

import com.mygdx.states.Splash;

public class TetrisEvolution extends Game {

	@Override
	public void create() {
		setScreen(new Splash());
		
	}

}
