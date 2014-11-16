package com.mygdx.tools;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Resources {

	public static final Texture getTexture(String imageName){
		return new Texture(Gdx.files.internal("res/img/" + imageName));
	}
	
	public static final TextureRegion getTextureRegion(Texture texture, int x, int y, int width, int height){
		return new TextureRegion(texture, x, y, width, height);
	}
	
	public static final HashMap<Integer, TextureRegion> splitImage(String imageName, int width, int height){
		Texture texture = getTexture(imageName);
		
		HashMap<Integer, TextureRegion> splitTexture = new HashMap<Integer, TextureRegion>();
		
		for (int column = 0; column < (int) texture.getWidth() / 32; column++) {
			splitTexture.put(column, getTextureRegion(texture, column * 32, 0, 32, 32));
		}
		
		return splitTexture;
	}
}
