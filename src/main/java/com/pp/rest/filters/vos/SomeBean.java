package com.pp.rest.filters.vos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"value3"})
public class SomeBean {

	private String value3;
	
	@JsonIgnore
	private String value2;
	private String value1;

	public SomeBean(String v1, String v2, String v3) {
		this.value1=v1;
		this.value2=v2;
		this.value3=v3;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}
	
	
	

}
