package com.ineuron.ai.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ineuron.ai.entity.User;

@Controller
public class HomeController {
	
	
@GetMapping("/")
	public String index(Model m) {
	m.addAttribute("date", new java.util.Date());
	
	
	User user1=new User(1,"Gaurav","Gaya");
	m.addAttribute("user1",user1);
	m.addAttribute("status",true);
	m.addAttribute("msg","GauravKeepGoing");
	m.addAttribute("user2", null);
		return "index";
	}


@GetMapping("/profile")
public String profile() {
	
	return "profile";
}




}
