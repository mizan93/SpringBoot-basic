package com.mizn.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mizan.main.model.Programmer;
import com.mizan.main.repository.ProgrammerReport;

@Controller
@ControllerAdvice
public class MainController {

	@Autowired
	ProgrammerReport pr;

	@ModelAttribute
	public void welcome(Model model) {
		model.addAttribute("msg", "Welcome to Spring Boot Tutorial");
	}

	@GetMapping("/")
	public String Index() {
		return "Welcom to Spring Boot";
	}
	@GetMapping("/home")
	public String homePage() {
		return "Home.html";
	}

	@GetMapping("/allprogrammer")
	public String allProgrammer(Model m) {
		ArrayList<Programmer> p = new ArrayList<Programmer>();
		p.add(new Programmer(101, "mizan", "Java"));
		p.add(new Programmer(102, "rasel", "Java2"));
		p.add(new Programmer(103, "sumu", "Java3"));
		m.addAttribute("programmer", p);
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
		pr.save(programmer);
		return "redirect:/home";
	}

	@PostMapping("/findById")
	public String findById(@RequestParam int id, Model model) {

		Programmer p = pr.getOne(id);
		model.addAttribute("p", p);
		return "ProgrammerInfo.html";
	}

	@PostMapping("/findByLanguage")
	public String findByLanguage(@RequestParam String language, Model model) {
		List<Programmer> p = pr.findP(language);
		model.addAttribute("programmers", p);
		return "allProgrammer.html";
	}

	@GetMapping("/deleteById")
	public String deleteById(@RequestParam int id) {
		pr.deleteById(id);
		return "redirect:/home";
	}

	@PostMapping("/updateProgrammer")
	public String updateProgrammer(@ModelAttribute Programmer programmer) {
		Programmer p = pr.getOne(programmer.getId());
		p.setName(programmer.getName());
		p.setLanguage(programmer.getLanguage());
		pr.save(p);
		return "redirect:/home";
	}

}
