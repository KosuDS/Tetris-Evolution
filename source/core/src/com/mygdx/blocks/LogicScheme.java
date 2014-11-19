package com.mygdx.blocks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.mygdx.tools.Resources;

public class LogicScheme {
	
	private Array<Connect> connects;
	private Map<Integer, Block> blocks;
	private Map<Integer, Level> levels;

	public LogicScheme(){
		connects = new Array<Connect>();
		blocks = new HashMap<Integer, Block>();
		levels = new HashMap<Integer, Level>();
	}
	
	public void checkConnects(BlocksBox blocksBox, float x, float y){
		
		int activeBlockIndex = blocksBox.getBlockIndex(x, y);
		
		if (activeBlockIndex != -1){
			Block activeBlock = blocksBox.getBlocks().get(activeBlockIndex);
			
			Array<Integer> finalIdexBlocks = new Array<Integer>();
			
			for (Connect connect : connects) {
				int value = 0;
				finalIdexBlocks.clear();
				
				for (int dirIndex = 0; dirIndex < connect.getDirections().length; dirIndex++) {
					int[] direction = connect.getDirections()[dirIndex];
					int condition = connect.getConditions()[dirIndex];
					
					int blockIndex = blocksBox.getBlockIndex(x + direction[0] * activeBlock.getWidth(), y + direction[1] * activeBlock.getHeight());
					
					if (blockIndex == -1){
						finalIdexBlocks.clear();
						break;
					} else {
						
						Block block = blocksBox.getBlocks().get(blockIndex);
						
						if (block.getBlockId() != condition){
							finalIdexBlocks.clear();
							break;
						} else {
							value += 1;
							finalIdexBlocks.add(blockIndex);
							
							if (value == connect.getDirections().length){
								Array<Block> toRemove = new Array<Block>();
								
								for (int index = 0; index < finalIdexBlocks.size; index++) {
									int actualBlockIndex = finalIdexBlocks.get(index);
									Block actualBlock = blocksBox.getBlocks().get(actualBlockIndex);
									
									int substitution = connect.getSubstitution()[index];
									
									if (substitution == -1) toRemove.add(actualBlock);
									else {
										activeBlock.setImageId(substitution);
									}
								}
								
								blocksBox.getBlocks().removeAll(toRemove, false);
								
								return;
							}
						}
					}
				}
			}
		}
	}
	
	public void addConnect(Connect connect){
		connects.add(connect);
	}
	
	public void addBlock(int id, Block block){
		blocks.put(id, block);
	}
	
	public void addLevel(int id, Level level){
		levels.put(id, level);
	}
	
	public Map<Integer, Block> getBlocks() {
		return blocks;
	}
	
	public Map<Integer, Level> getLevels() {
		return levels;
	}
	
	public Array<Connect> getConnects() {
		return connects;
	}


}
