package com.drone.common;

public enum Range {

	ONE(1), TWO(2);

	private Integer value;

	private Range(Integer i) {
        value = i;
    }

	public Integer getValue() {
		return value;
	}

}
