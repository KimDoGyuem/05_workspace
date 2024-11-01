package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dto.AccountDto;
import com.project.dto.GuestDto;
import com.project.service.GuestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/guest/*")
@AllArgsConstructor
@Controller
public class GuestController {
	
	private GuestService service;
	
	@GetMapping("/getList")
	public void getList(@RequestParam(value="word", defaultValue = "null") String word,@RequestParam(value="currentPage",defaultValue = "1") int currentPage,Model model) {
		model.addAttribute("blp",service.getList(word, currentPage));
	}
	
	@GetMapping({"/read", "/modify"})
	public void read(@RequestParam("bno") Long bno, Model model) {
		model.addAttribute("read",service.read(bno));
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		service.del(bno);
		return "redirect:/guest/getList?currentPage=1";
	}
	
	@PostMapping("/write")
	public String write(GuestDto dto) {
		service.write(dto);
		return "redirect:/guest/getList?currentPage=1";
	}
	
	@GetMapping("/write")
	public void write() {
		
	}
	
	@PostMapping("/modify")
	public String modify(GuestDto dto) {
		service.modify(dto);
		return "redirect:/guest/getList?currentPage=1";
	}
	
	@GetMapping("/reg")
	public void reg() {
		
	}
	
	@PostMapping("/reg")
	public void reg(AccountDto a,Model model) {
		model.addAttribute("regCount", service.regCount(a));
		service.reg(a);
	}
	
	@GetMapping("/log")
	public void log(Model model) {
		model.addAttribute("notLog","x");
	}
	
	@PostMapping("/log")
	public void log(HttpSession s,AccountDto a,Model model) {
		model.addAttribute("notLog","y");
		s.setAttribute("log", service.log(a));
	}
	
	@GetMapping("/logOut")
	public String logOut(HttpSession s) {
		s.invalidate();
		return "redirect:/";
	}
}
