package pl.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.webproject.service.ForumService;

@Controller
public class LoginController {
	
	@GetMapping("/showLoginPage")
	public String showLoginPage(){
		
		return "login-page";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		
		return "access-denied";
	}
}
