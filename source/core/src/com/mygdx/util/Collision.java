package com.mygdx.util;

public class Collision {
	
	public final static boolean checkCollisionWithPoint(float x, float y, float width, float height, float x1, float y1, float width1, float height1){
		width = width - 1;
		x = x + 1;
		
		width1 = width1 - 1;
		x1 = x1 + 1;
		
		if (x >= x1 && x <= x1 + width1 && y >= y1 && y <= y1 + height) return true; // Left bottom 
		if (x + width >= x1 && x + width <= x1 + width1 && y >= y1 && y <= y1 + height) return true; // Right bottom 
		if (x >= x1 && x <= x1 + width1 && y + height >= y1 && y + height <= y1 + height1) return true; // Left up
		if (x + width >= x1 && x + width <= x1 + width1 && y + height >= y1 && y + height <= y1 + height1) return true; // Right up
		
		if (x1 >= x && x1 <= x + width && y1 >= y && y1 <= y + height1) return true; // Left bottom 
		if (x1 + width1 >= x && x1 + width1 <= x + width && y1 >= y && y1 <= y + height1) return true; // Right bottom 
		if (x1 >= x && x1 <= x + width && y1 + height1 >= y && y1 + height1 <= y + height) return true; // Left up
		if (x1 + width1 >= x && x1 + width1 <= x + width && y1 + height1 >= y && y1 + height1 <= y + height) return true; // Right up
		
		return false;
	}
	
	public final static boolean checkCollisionWithBorder(float x, float y, float wigth, float height, float widthScreen, float heightScreen){
		if (x < 0) return true;
		if (y < 0) return true;
		
		if (x + wigth > widthScreen) return true;
		if (y + height > heightScreen) return true;
		
		return false;
	}
}
