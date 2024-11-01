package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.service.MhService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/nexon/*")
@AllArgsConstructor
@Controller
public class MhController {
	
	private MhService service;
	
	@GetMapping("/mhCharacter")
	public void mhCharacter() {
	}
	
	@PostMapping("/mhCharacter")
	public void mhCharacter(@RequestParam("name") String name, Model model) {
		model.addAttribute("ocid", service.nameSearch(name));
	}
	
	@GetMapping("/characterBasic")
	public void characterBasic(@RequestParam("ocid") String ocid, Model model) {
		service.characterBasic(ocid, model);
		service.characterStat(ocid, model);
		service.characterGuild(ocid, model);
	}
	
	@GetMapping("/mhRanking")
	public void mhRanking() {
		
	}
	
	@PostMapping("/mhRanking")
	public void mhRanking(@RequestParam("type") String type, Model model) {
		service.mhRanking(type, model);
	}
	
	@GetMapping("/rankingCharacter")
	public String rankingCharacter(@RequestParam("name") String name) {
		String ocid = service.nameSearch(name);
		return "redirect:/nexon/characterBasic?ocid="+ocid;
	}
}