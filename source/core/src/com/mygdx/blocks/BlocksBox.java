package com.mygdx.blocks;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.utils.Array;

public class BlocksBox {
	private Array<Block> blocks;
	
	public BlocksBox(){
		blocks = new Array<Block>();
	}
	
	public boolean checkBlockCollisionWithOtherBlocks(Block block, float xMove, float yMove){
		for (Block otherBlock : getBlocks()) {
			if (!block.equals(otherBlock) && block.checkCollisionWithBlock(xMove, yMove, otherBlock)){
				return true;
			}
		}
		
		return false;
	}
	
	public Array<Block> getBlocks(){
		return blocks;
	}
	
	public Block getBlock(float x, float y){
		for (Block block : getBlocks()) {
			if (block.checkCollisionWithPoint(0, 0, x, y, 1, 1)) return block;
		}
		
		return null;
	}
	
	public int getBlockIndex(float x, float y){
		for (int index = 0; index < blocks.size; index++) {
			if (blocks.get(index).checkCollisionWithPoint(0, 0, x, y, 1, 1)) return index;
		}
		
		return -1;
	}
}
