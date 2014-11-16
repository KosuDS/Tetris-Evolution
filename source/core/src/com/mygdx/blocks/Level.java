package com.mygdx.blocks;

public class Level {
	private int[] blocksId;
	private int[] values;
	private int[] responses;
	
	public Level(int[] blocksId, int[] values, int[] responses){
		setBlocksId(blocksId);
		setValues(values);
		setResponses(responses);
	}

	public int[] getBlocksId() {
		return blocksId;
	}

	public void setBlocksId(int[] blocksId) {
		this.blocksId = blocksId;
	}

	public int[] getValues() {
		return values;
	}

	public void setValues(int[] values) {
		this.values = values;
	}

	public int[] getResponses() {
		return responses;
	}

	public void setResponses(int[] responses) {
		this.responses = responses;
	}
}
