package com.peisia.dto;

import java.util.ArrayList;

import lombok.Data;

@Data	
public class Cat {	
	private String name;
	private Integer age;
	private ArrayList<String> hobby = new ArrayList<String>();
	private ArrayList<Animal> friends = new ArrayList<Animal>();
	private ArrayList<String> aaa = null;
}	
