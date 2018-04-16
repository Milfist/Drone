package com.drone.common;

public enum Directions {

	UP("UP"), DOWN("DOWN"), RIGHT("RIGHT"), LEFT("LEFT");

	private String value;

	Directions(String i) {
		value = i;
	}

	public String getValue() {
		return value == null ? "OTHER" : value;
	}

}
