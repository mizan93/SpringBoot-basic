package com.mizn.main.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mizan.main.model.Programmer;

@Controller
@ControllerAdvice
public class MainController {
	
	@ModelAttribute
	public void welcome(Model model) {
		model.addAttribute("msg","Welcome to Spring Boot Tutorial");
	}
	@GetMapping("/home")
	public String homePage() {
		return "Home.html";
	}
	@RequestMapping("/user")
	public String abouPage() {
		return "User.html";
	}
	@GetMapping("/allprogrammer")
	public String allProgrammer(Model m) {
		ArrayList<Programmer>p=new ArrayList<Programmer>();
		p.add(new Programmer(101,"mizan","Java"));
		p.add(new Programmer(102,"rasel","Java2"));
		p.add(new Programmer(103,"sumu","Java3"));
		m.addAttribute("programmer",p);
		return "allProgrammer.html";
	}
	@PostMapping("/addProgrammer")
	public String addProgrammer(@ModelAttribute("p") Programmer programmer) {
//		ModelAndView mv=new ModelAndView();
//			mv.setViewName("ProgrammerInfo.html");
//			
//			return mv;
//		model.addAttribute("id",i);
//		model.addAttribute("name",n);
//		model.addAttribute("language",l);
		return "ProgrammerInfo.html";
	}
	@RequestMapping("/addUser")
	public String addUser(@RequestParam String name,@RequestParam String phone,@RequestParam String email,ModelMap model ) {
//		System.out.println(email+" "+name+" "+phone);
		model.addAttribute("name",name);
		model.addAttribute("phone",phone);
		model.addAttribute("email",email);
		return "UserInfo.html";
	}
	
	
}
