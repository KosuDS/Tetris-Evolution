package com.mygdx.blocks;

import com.mygdx.util.Collision;

public class Block {
	private float x;
	private float y;
	private int width;
	private int height;
	private int rotation;
	
	private int blockId;
	private int imageId;
	private float speedFalling;
	
	public Block(float x, float y, int width, int height, int rotation, int blockId, int imageId, float speedFalling){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setRotation(rotation);
		
		setBlockId(blockId);
		setImageId(imageId);
		setSpeedFalling(speedFalling);
	}

	public boolean checkCollisionWithBlock(float xMove, float yMove, Block block){
		if (Collision.checkCollisionWithPoint(getX() + xMove, getY() + yMove, getWidth(), getHeight(), block.getX(), block.getY(), block.getWidth(), block.getHeight())){
			return true;
		}
		
		return false;
	}
	
	public boolean checkCollisionWithPoint(float xMove, float yMove, float xPoint, float yPoint, int widthPoint, int heightPoint){
		if (Collision.checkCollisionWithPoint(getX() + xMove, getY() + yMove, getWidth(), getHeight(), xPoint, yPoint, widthPoint, heightPoint)){
			return true;
		}
		
		return false;
	}
	
	public boolean checkCollisionWithBorder(float xMove, float yMove, int widthBorder, int heightBorder){
		if (Collision.checkCollisionWithBorder(getX() + xMove, getY() + yMove, getWidth(), getHeight(), widthBorder, heightBorder)){
			return true;
		}
		
		return false;
	}

	public float getX() {
		return x;
	}

	public void setX(float x2) {
		this.x = x2;
	}

	public float getY() {
		return y;
	}

	public void setY(float y2) {
		this.y = y2;
	}

	public int getBlockId() {
		return blockId;
	}

	public void setBlockId(int imageId) {
		this.blockId = imageId;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height2) {
		this.height = height2;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width2) {
		this.width = width2;
	}

	public float getSpeedFalling() {
		return speedFalling;
	}

	public void setSpeedFalling(float speedFalling2) {
		this.speedFalling = speedFalling2;
	}
	
	public void move(float x, float y){
		setX(getX() + x);
		setY(getY() + y);
	}

	public int getRotation() {
		return rotation;
	}
	
	public void setRotation(int rotation2) {
		this.rotation = rotation2;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	
}
