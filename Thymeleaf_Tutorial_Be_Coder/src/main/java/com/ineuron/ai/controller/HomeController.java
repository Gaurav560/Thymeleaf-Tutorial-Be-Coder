package com.ineuron.ai.controller;



import java.util.ArrayList;
import java.util.List;

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
public String profile(Model m1) {
	User user1=new User(1, "amar", "gaya");
	User user2=new User(2, "gaurav", "gaya");
	User user3=new User(3, "sharma", "gaya");
	User user4=new User(4, "ar", "gaya");
	User user5=new User(5, "rocky", "gaya");
	User user6=new User(6, "keyyy", "gaya");
	User user7=new User(7, "rjvrn", "gaya");
	
	ArrayList<User> list=new ArrayList<>();
	list.add(user1);
	list.add(user2);
	list.add(user3);
	list.add(user4);
	list.add(user5);
	list.add(user6);
	list.add(user7);

	m1.addAttribute("userList", list);
	
	return "profile";
}




}
