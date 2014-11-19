package com.mygdx.modes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.mygdx.blocks.Block;
import com.mygdx.blocks.BlocksBox;
import com.mygdx.blocks.Connect;
import com.mygdx.blocks.Level;
import com.mygdx.blocks.LogicScheme;
import com.mygdx.tools.InvertXY;
import com.mygdx.tools.Resources;

public class Mode {
	
	private final Random random = new Random();
	
	private int width;
	private int height;
	
	private final int widthPixel = Gdx.graphics.getWidth();
	private final int heightPixel = Gdx.graphics.getHeight();
	private final int halfScreenVertical = widthPixel / 2;
	private final int halfScreenHorizontal = widthPixel / 2;
	
	private int widthBlock;
	private int heightBlock;
	
	private BlocksBox blocksBox;
	private Map<Integer, TextureRegion> textureBlocks;
	
	private Level actualLevel;
	private Block actualBlock;
	private Block nextBlock;
	
	private LogicScheme scheme;

	public Mode(int width, int height, int widthBlock, int heightBlock, String texturePackName){
		this.width = width;
		this.height = height;
		this.widthBlock = widthBlock;
		this.heightBlock = heightBlock;
		
		blocksBox = new BlocksBox();
		textureBlocks = Resources.splitImage(texturePackName, widthBlock, heightBlock);
	}
	
	private void refreschScheme(){
		actualLevel = null;
		
		Block block = scheme.getBlocks().get(0);
		
		actualBlock = new Block(block.getX(), block.getY(), block.getWidth(), block.getHeight(), block.getRotation(), block.getBlockId(), block.getImageId(), block.getSpeedFalling());
		nextBlock = new Block(block.getX(), block.getY(), block.getWidth(), block.getHeight(), block.getRotation(), block.getBlockId(), block.getImageId(), block.getSpeedFalling());
	}

	public void checkEvents(int screenX, int screenY){
		screenY = InvertXY.invert(screenY, heightPixel, 0);
		
		checkLogic(screenX, screenY);
		
		if (actualBlock.checkCollisionWithPoint(0, 0, screenX, screenY, 1, 1)){
			actualBlock.setSpeedFalling(actualBlock.getSpeedFalling());
		}

		if (screenX < halfScreenVertical){
			if (actualBlock.checkCollisionWithPoint(-actualBlock.getWidth(), 0, screenX, screenY, 1, 1)){
				
				if (!blocksBox.checkBlockCollisionWithOtherBlocks(actualBlock, -actualBlock.getWidth(), 0)|| actualBlock.checkCollisionWithBorder(-actualBlock.getWidth(), 0, widthPixel, heightPixel)) {
					actualBlock.move(-actualBlock.getWidth(), 0);
				}
			}
		} else if (screenX > halfScreenVertical){
			if (actualBlock.checkCollisionWithPoint(actualBlock.getWidth(), 0, screenX, screenY, 1, 1)){
				
				if (!blocksBox.checkBlockCollisionWithOtherBlocks(actualBlock, actualBlock.getWidth(), 0) || actualBlock.checkCollisionWithBorder(actualBlock.getWidth(), 0, widthPixel, heightPixel)) {
					actualBlock.move(actualBlock.getWidth(), 0);
				}
			}
		}
	}
	
	public void randomNextBlock(){
		blocksBox.getBlocks().add(actualBlock);
		
		actualBlock = nextBlock;
		
		float x = (random.nextInt(width) * widthBlock);
		float y = height * heightBlock;
		
		Block block = scheme.getBlocks().get(0);
		nextBlock = new Block(x, y, block.getWidth(), block.getHeight(), block.getRotation(), block.getBlockId(), block.getImageId(), block.getSpeedFalling());
	}
	
	private void checkLogic(float x, float y){

		scheme.checkConnects(blocksBox, x ,y);
	}
	
	public void draw(SpriteBatch batch){
		textureBlocks.get(actualBlock.getImageId());
		batch.draw(textureBlocks.get(actualBlock.getImageId()), actualBlock.getX(), actualBlock.getY());
		
		for (Block block : blocksBox.getBlocks()) {
			batch.draw(textureBlocks.get(block.getImageId()), block.getX(), block.getY());
		}
		
	}
	
	public void update(float delta){
			
		if (blocksBox.checkBlockCollisionWithOtherBlocks(actualBlock, 0, actualBlock.getSpeedFalling() * delta) || actualBlock.checkCollisionWithBorder(0, actualBlock.getSpeedFalling() * delta, widthPixel, heightPixel)){
			randomNextBlock();
		} else {
			actualBlock.move(0, actualBlock.getSpeedFalling() * delta);
		}
		
		for (int index = 0; index < blocksBox.getBlocks().size; index++) {
			Block block = blocksBox.getBlocks().get(index);
			
				if (!blocksBox.checkBlockCollisionWithOtherBlocks(block, 0, block.getSpeedFalling() * delta) && !block.checkCollisionWithBorder(0, block.getSpeedFalling() * delta, widthPixel, heightPixel)){
				
				block.move(0, block.getSpeedFalling() * delta);
			}
		}
		
		/***
		for (Block block : blocksBox.getBlocks()) {
			if (!checkBlockCollisionWithOtherBlocks(block, 0, block.getSpeedFalling() * delta) && !block.checkCollisionWithBorder(0, block.getSpeedFalling() * delta, widthPixel, heightPixel)){
				
				block.move(0, block.getSpeedFalling() * delta);
			}
		}
		***/
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public LogicScheme getScheme() {
		return scheme;
	}

	public void setScheme(LogicScheme scheme) {
		this.scheme = scheme;
		
		refreschScheme();
	}
}
