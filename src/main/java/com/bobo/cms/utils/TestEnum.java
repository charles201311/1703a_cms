package com.bobo.cms.utils;

public enum TestEnum {

	Male("male", "男"), FEMALE("female", "女");
	String code;
	String name;

	TestEnum(String code, String name) {
		this.code = code;
		this.name = name;

	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public static void main(String[] args) {
		//System.out.println(TestEnum.Male.getCode()+":"+TestEnum.Male.getName());
		for(TestEnum t:TestEnum.values())
		System.out.println(t);
	}

}


