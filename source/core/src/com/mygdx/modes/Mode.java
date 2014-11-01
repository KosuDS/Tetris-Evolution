package com.mygdx.modes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.mygdx.blocks.Block;

public class Mode {
	
	private final Random random = new Random();
	
	private int width;
	private int height;
	
	private final int widthPixel = Gdx.graphics.getWidth();
	private final int heightPixel = Gdx.graphics.getHeight();
	private final int halfScreenVertical = widthPixel / 2;
	private final int halfScreenHorizontal = widthPixel / 2;
	
	private final static int defaultSpeedFalling = 10;
	private final static int acceleratedSpeedFalling =  defaultSpeedFalling * 2;
	
	private final static int defaultWidthBlock = 64;
	private final static int defaultHeightBlock = 64;
	
	private float defaultDeltaInterval = 0;
	private float storageDelta = 0;
	
	private Map<Integer, Block> blocks;
	
	private Block actualBlock;
	private Block nextBlock;
	
	public Mode(int width, int height, float deltaInterval){
		setWidth(width);
		setHeight(height);
		setDefaultDeltaInterval(deltaInterval);
		
		
		blocks = new HashMap<Integer, Block>();
	}
	
	public boolean checkBlockCollisionWithOtherBlocks(Block block, int xMove, int yMove){
		for (Block otherBlock : blocks.values()) {
			if (block.checkCollisionWithBlock(xMove, yMove, otherBlock)){
				return true;
			}
		}
		
		return false;
	}

	public void checkEvents(int screenX, int screenY){
		if (actualBlock.checkCollisionWithPoint(0, 0, screenX, screenY, 1, 1)){
			actualBlock.setSpeedFalling(acceleratedSpeedFalling);
		}

		if (screenX < halfScreenVertical){
			if (actualBlock.checkCollisionWithPoint(-actualBlock.getWidth(), 0, screenX, screenY, 1, 1)){
				
				if (!checkBlockCollisionWithOtherBlocks(actualBlock, -actualBlock.getWidth(), 0)|| actualBlock.checkCollisionWithBorder(-actualBlock.getWidth(), 0, widthPixel, heightPixel)) {
					actualBlock.move(-actualBlock.getWidth(), 0);
				}
			}
		} else if (screenX > halfScreenVertical){
			if (actualBlock.checkCollisionWithPoint(actualBlock.getWidth(), 0, screenX, screenY, 1, 1)){
				
				if (!checkBlockCollisionWithOtherBlocks(actualBlock, actualBlock.getWidth(), 0) || actualBlock.checkCollisionWithBorder(actualBlock.getWidth(), 0, widthPixel, heightPixel)) {
					actualBlock.move(actualBlock.getWidth(), 0);
				}
			}
		}
	}
	
	public void randomNextBlock(){
		actualBlock = nextBlock;
		
		int x = random.nextInt(width) * defaultWidthBlock;
		int y = 0 * defaultHeightBlock;
		
		nextBlock = new Block(x, y, defaultWidthBlock, defaultHeightBlock, 0, defaultSpeedFalling);
	}
	
	public void update(float delta){
		
		if (storageDelta >= defaultDeltaInterval){
			
			if (checkBlockCollisionWithOtherBlocks(actualBlock, 0, actualBlock.getSpeedFalling()) || actualBlock.checkCollisionWithBorder(0, actualBlock.getSpeedFalling(), widthPixel, heightPixel)){
				randomNextBlock();
			} else {
				actualBlock.move(0, actualBlock.getSpeedFalling());
			}
	
			for (Block block : blocks.values()) {
				if (!checkBlockCollisionWithOtherBlocks(block, 0, block.getSpeedFalling())){
					block.move(0, block.getSpeedFalling());
				}
			}
			
			storageDelta = storageDelta - defaultDeltaInterval;
		}
		
		storageDelta += delta;
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

	public int getAcceleratedSpeedFalling() {
		return acceleratedSpeedFalling;
	}

	public int getDefaultSpeedFalling() {
		return defaultSpeedFalling;
	}
	
	public float getDefaultDeltaInterval() {
		return defaultDeltaInterval;
	}

	public void setDefaultDeltaInterval(float deltaInterval) {
		this.defaultDeltaInterval = deltaInterval;
	}
}
