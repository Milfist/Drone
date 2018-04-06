package com.drone.common;

public enum Directions {

	UP("UP"), DOWN("DOWN"), RIGHT("RIGHT"), LEFT("LEFT");

	private String value;

	private Directions(String s) {
        value = s;
    }

	public String getValue() {
		return value;
	}

}
