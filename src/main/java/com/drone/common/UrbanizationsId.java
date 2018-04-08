package com.drone.common;

public enum UrbanizationsId {

	ID_1("1"), ID_2("2"), ID_3("3"), ID_4("4"), ID_5("5"), ID_6("6"), ID_7("7"),
	ID_8("8"), ID_9("9"), ID_10("10"), ID_11("11"), ID_12("12"), ID_13("13"), ID_14("14"),
	ID_15("15"), ID_16("16"), ID_17("17"), ID_18("18"), ID_19("19"), ID_20("20"), ID_21("21"), 
	ID_22("22"), ID_23("23"), ID_24("24"), ID_25("25");  

	private String value;

	private UrbanizationsId(String s) {
        value = s;
    }

	public String getValue() {
		return value;
	}

}
