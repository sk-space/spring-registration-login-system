package com.project.registration;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.registration.dao.UserDao;
import com.project.registration.entity.User;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private UserDao uDao;
	
	@GetMapping
	public String getLogin(){
		return "login";
	}
	
	@PostMapping
	public String postLogin(@ModelAttribute User u, Model model){
		String encPass = UUID.nameUUIDFromBytes(u.getPassword().getBytes()).toString();
		User user = uDao.loginUser(u.getUsername(), encPass);
		if(user != null){
			model.addAttribute("user", user);
			return "redirect:/";
		}
		model.addAttribute("error", "User Does Not Exists...");
		model.addAttribute("u", u);
		return "login";
	}

}
