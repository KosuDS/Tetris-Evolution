package com.mygdx.util;

public class Collision {
	
	public final static boolean checkCollisionWithPoint(int x, int y, int width, int height, int x1, int y1, int width1, int height1){
		width = width - 1;
		x = x + 1;
		
		width1 = width1 - 1;
		x1 = x1 + 1;
		
		if (x >= x1 && x <= x1 + width1 && y >= y1 && y <= y1 + height) return true; // Left bottom 
		if (x + width >= x1 && x + width <= x1 + width1 && y >= y1 && y <= y1 + height) return true; // Right bottom 
		if (x >= x1 && x <= x1 + width1 && y + height >= y1 && y + height <= y1 + height1) return true; // Left up
		if (x + width >= x1 && x + width <= x1 + width1 && y + height >= y1 && y + height <= y1 + height1) return true; // Right up
		
		return false;
	}
	
	public final static boolean checkCollisionWithBorder(int x, int y, int wigth, int height, int widthScreen, int heightScreen){
		if (x < 0) return true;
		if (y < 0) return true;
		
		if (x + wigth > widthScreen) return true;
		if (y + height > heightScreen) return true;
		
		return false;
	}
}
