package com.mygdx.tools;

public class InvertXY {
	
	public final static int invert(int value, int totalHeight, int bitHeight){
		
		return (totalHeight - value) - bitHeight;
	}
}
