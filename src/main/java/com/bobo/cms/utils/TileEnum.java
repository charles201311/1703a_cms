package com.bobo.cms.utils;

public enum TileEnum  {
	
	COLOR("color:","red"),FONTWEIGHT("font-weight:","800"),FONTSTYLE("font-style:","italic");
	private String code;
	private String value;
	 TileEnum(String code, String value) {
		this.code = code;
		this.value = value;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public static void main(String[] args) {
	}

}
