package com.mygdx.blocks;

import java.util.Map;

public class Connect {
	private int[][] directions;
	private int[] conditions;
	private int[] substitution;

	public Connect(int[][] directions, int[] conditions, int[] substitution) {
		setDirections(directions);
		setConditions(conditions);
		setSubstitution(substitution);
	}

	public int[][] getDirections() {
		return directions;
	}

	public void setDirections(int[][] directions) {
		this.directions = directions;
	}

	public int[] getConditions() {
		return conditions;
	}

	public void setConditions(int[] conditions) {
		this.conditions = conditions;
	}

	public int[] getSubstitution() {
		return substitution;
	}

	public void setSubstitution(int[] substitution) {
		this.substitution = substitution;
	}

}
