package com.mygdx.states;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.modes.DarwinMode;

public class MainMenu implements Screen {

	private Stage stage;
	private Skin skin;
	private Table table;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(stage.getViewport());
		table.invalidateHierarchy();
	}

	@Override
	public void show() {
		stage = new Stage();

		Gdx.input.setInputProcessor(stage);

		skin = new Skin(Gdx.files.internal("res/ui/menuSkin.json"), new TextureAtlas("res/ui/atlas.pack"));

		table = new Table(skin);
		table.setFillParent(true);

		Label heading = new Label("Tetris->Evolution", skin, "big");
		heading.setFontScale(0.8f);

		TextButton buttonPlay = new TextButton("PLAY", skin, "big");
		buttonPlay.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.addAction(sequence(moveTo(0, stage.getHeight(), .5f), run(new Runnable() {

					@Override
					public void run() {
						((Game) Gdx.app.getApplicationListener()).setScreen(new com.mygdx.game.Game(new DarwinMode()));
					}
				})));
			}
		});
		buttonPlay.pad(15);

		TextButton buttonInfo = new TextButton("INFO", skin);
		buttonInfo.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.addAction(sequence(moveTo(0, stage.getHeight(), .5f), run(new Runnable() {

					@Override
					public void run() {
						((Game) Gdx.app.getApplicationListener()).setScreen(new Info());
					}
				})));
			}
		});
		buttonInfo.pad(15);

		table.add(heading).spaceBottom(100).row();
		table.add(buttonPlay).spaceBottom(15).row();
		table.add(buttonInfo).spaceBottom(15).row();

		stage.addActor(table);
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		stage.dispose();
		skin.dispose();
	}

}
