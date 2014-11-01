package com.mygdx.util;

public class Collision {
	
	public final static boolean checkCollisionWithPoint(int x, int y, int width, int height, int x1, int y1, int width1, int height1){
		
		if (x >= x1 && x <= x1 + width1){
			if (y >= y1 && y <= y1 + height1) return true;
			
			if (y + height <= y1 + height1 && y + height >= y1) return true;
		}
		
		if (x + width >= x1 && x + width <= x1 + width1){
			if (y >= y1 && y <= y1 + height1) return true;
			
			if (y + height <= y1 + height1 && y + height >= y1) return true;
		}
		
		if (x1 >= x && x1 <= x + width){
			if (y1 >= y && y1 <= y + height) return true;
			
			if (y1 + height1 <= y + height && y1 + height1 >= y) return true;
		}
		
		if (x1 + width1 >= x && x1 + width1 <= x + width){
			if (y1 >= y && y1 <= y + height) return true;
			
			if (y1 + height1 <= y + height && y1 + height1 >= y) return true;
		}
		
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
