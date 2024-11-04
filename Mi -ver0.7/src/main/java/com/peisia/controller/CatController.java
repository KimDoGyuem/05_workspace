package com.peisia.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peisia.dto.Animal;
import com.peisia.dto.Cat;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RestController				
@RequestMapping("/api/*")				
public class CatController {	
	
	@GetMapping("/catOne")			
	public Cat getCatOne() {			
		Cat cat = new Cat();
		cat.setName("야옹이");		
		cat.setAge(5);
		cat.getHobby().add("잠자기");
		cat.getHobby().add("밥먹기");
		cat.getHobby().add("야옹하기");
		cat.getFriends().add(new Animal("개", 3));
		cat.getFriends().add(new Animal("새", 2));
		
		Animal ani = new Animal(null, null);  //lombok 써서 해본거
		ani.setName("쥐");
		ani.setAge(1);
		cat.getFriends().add(ani);
		
		cat.setAaa(new ArrayList<String>());
		cat.getAaa().add("응애");
		//이렇게 객체를 리턴하면 json 이 객체 구조로 해서 자동으로 출력됨. 		
		//즉, 이 주소로 api 요청을 하면 		
		//고양이 이름, 나이 json을 받아갈 수 있게 되는 것.		
		return cat; 		
	}		
	
	
	@GetMapping("/example")					
	public Map<String, Object> example() {					
		Map<String, String> data1 = new HashMap<>();				
		data1.put("message", "Hello, World!");	
		data1.put("abc", "def");
		data1.put("가나다", "라마바사");
		
		Map<String, Integer> data2 = new HashMap<>();	
		data2.put("message", 123);	
		data2.put("abc", 456);
		data2.put("가나다", 789);
		
		Map<String, Object> data3 = new HashMap<>();
		data3.put("test1", data1);
		data3.put("test2", data2);
		return data3;				
	}		
	
}				