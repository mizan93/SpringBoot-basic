package com.mizn.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mizan.main.model.User;
import com.mizan.main.repository.UserReport;

@Controller
@ControllerAdvice
public class UserController {
	@Autowired
	UserReport userReport;

	@ModelAttribute
	public void welcome(Model model) {
		model.addAttribute("msg", "Welcome to Spring Boot Tutorial");
	}

	@GetMapping("/user")
	public String serPage() {
		return "User.html";
	}

	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("u") User user) {
		userReport.save(user);
		return "redirect:/user";
	}

//	@PostMapping("/findById")
//	public String findUserById(@RequestParam int id, Model model) {
//		User user = userReport.getOne(id);
//		model.addAttribute("user", user);
//		return "userInfo.html";
//	}
////
//	@PostMapping("/findByName")
//	public String findByName(@RequestParam String name, Model model) {
//		List<User> users = userReport.findByName(name);
//		model.addAttribute("users", users);
//		return "allUser.html";
//	}
//
//	@GetMapping("/deleteById")
//	public String deleteUserById(@RequestParam int id) {
//		userReport.deleteById(id);
//		return "redirect:/user";
//	}
//
//	@PostMapping("/updateUser")
//	public String updateProgrammer(@ModelAttribute User user) {
//		User u = userReport.getOne(user.getId());
//		u.setName(user.getName());
//		u.setPhone(user.getPhone());
//		userReport.save(u);
//		return "redirect:/user";
//	}

}
