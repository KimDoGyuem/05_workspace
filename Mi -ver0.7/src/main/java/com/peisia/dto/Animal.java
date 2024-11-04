package com.peisia.dto;

import lombok.Data;

@Data
public class Animal {
	private String name;
	private Integer age;
	
	public Animal(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
}
