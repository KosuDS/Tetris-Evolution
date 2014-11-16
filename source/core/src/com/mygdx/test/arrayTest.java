package com.mygdx.test;

import com.badlogic.gdx.utils.Array;
import com.mygdx.blocks.Block;

public class arrayTest {
	public static void main(String[] args){
		Array<Block> lol = new Array<Block>();
		
		lol.add(new Block(1, 1, 1, 1, 1, 1, 1, 1));
		lol.add(new Block(1, 1, 1, 1, 1, 1, 1, 1));
		lol.add(new Block(1, 1, 1, 1, 1, 1, 1, 1));
		
		for (Block integer : lol) {
			System.out.print(integer);
		}
	}
}
