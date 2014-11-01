package com.mygdx.blocks;

import com.mygdx.util.Collision;

public class Block {
	private int x;
	private int y;
	private int width;
	private int height;
	
	private int imageId;
	private int speedFalling;
	
	public Block(int x, int y, int width, int height, int imageId, int speedFalling){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		
		setImageId(imageId);
		setSpeedFalling(speedFalling);
	}
	
	
	
	public boolean checkCollisionWithBlock(int xMove, int yMove, Block block){
		if (Collision.checkCollisionWithPoint(getX() + xMove, getY() + yMove, getWidth(), getHeight(), block.getX(), block.getY(), block.getWidth(), block.getHeight())){
			return true;
		}
		
		return false;
	}
	
	
	public boolean checkCollisionWithPoint(int xMove, int yMove, int xPoint, int yPoint, int widthPoint, int heightPoint){
		if (Collision.checkCollisionWithPoint(getX() + xMove, getY() + yMove, getWidth(), getHeight(), xPoint, yPoint, widthPoint, heightPoint)){
			return true;
		}
		
		return false;
	}
	
	public boolean checkCollisionWithBorder(int xMove, int yMove, int widthBorder, int heightBorder){
		if (Collision.checkCollisionWithBorder(getX() + xMove, getY() + yMove, getWidth(), getHeight(), widthBorder, heightBorder)){
			return true;
		}
		
		return false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getSpeedFalling() {
		return speedFalling;
	}

	public void setSpeedFalling(int speedFalling) {
		this.speedFalling = speedFalling;
	}
	
	public void move(int x, int y){
		setX(getX() + x);
		setY(getY() + y);
	}
	
}
