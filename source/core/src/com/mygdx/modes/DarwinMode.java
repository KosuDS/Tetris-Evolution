package com.mygdx.modes;

import com.mygdx.blocks.Block;
import com.mygdx.blocks.Connect;
import com.mygdx.blocks.Level;
import com.mygdx.blocks.LogicScheme;

public class DarwinMode extends Mode{
	
	private static int widthBlock = 32;
	private static int heightBlock = 32;
	private static int rotation = 0;
	
	private static int width = 5;
	private static int height = 7;
	
	private static float speedFalling = -50;
	
	private static String texturePackName = "textureSet.png";
	
	private LogicScheme scheme = new LogicScheme();
	
	public DarwinMode(){
		super(width, height, widthBlock, heightBlock, texturePackName);
		
		scheme.addBlock(0, new Block(0f, 110f, widthBlock, heightBlock, rotation, 0, 0, speedFalling * 2));
		scheme.addBlock(1, new Block(0f, 110f, widthBlock, heightBlock, rotation, 1, 1, speedFalling));
		scheme.addBlock(2, new Block(0f, 0f, widthBlock, heightBlock, rotation, 2, 2, speedFalling));
		scheme.addBlock(3, new Block(0f, 0f, widthBlock, heightBlock, rotation, 3, 3, speedFalling));
		
		scheme.addConnect(new Connect(new int[][]{{0, 0}, {-1, 0}, {1, 0}}, new int[]{0, 0, 0}, new int[]{1, -1, -1}));
		scheme.addConnect(new Connect(new int[][]{{0, 0}, {-1, 0}, {-2, 0}}, new int[]{0, 0, 0}, new int[]{1, -1, -1}));
		scheme.addConnect(new Connect(new int[][]{{0, 0}, {1, 0}, {2, 0}}, new int[]{0, 0, 0}, new int[]{1, -1, -1}));
		
		scheme.addLevel(0, new Level(new int[]{0}, new int[]{1}, new int[]{0})); //What i need to this level, value block, what i want get
		scheme.addLevel(1, new Level(new int[]{1}, new int[]{1}, new int[]{1}));
		scheme.addLevel(2, new Level(new int[]{2}, new int[]{1}, new int[]{2}));
		
		super.setScheme(scheme);
	}
	
	public void update(float delta){
		super.update(delta);
	}
}
