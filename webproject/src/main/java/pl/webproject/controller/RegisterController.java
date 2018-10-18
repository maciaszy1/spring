package pl.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.webproject.entity.User;
import pl.webproject.service.ForumService;
import pl.webproject.service.UserService;
import pl.webproject.user.WpUser;

@Transactional
@Controller
public class RegisterController {
	
	@Autowired
	UserService userDetailService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	ForumService forumService;
	
	@GetMapping("/showRegistrationPage")
	public String showRegistration(Model theModel) {
		
		WpUser wpUser = new WpUser();
		theModel.addAttribute("wpUser",wpUser);
		
		return "registration-page";
	}
	
	@PostMapping("/processRegistration")
	public String processRegistration(@ModelAttribute("wpUser") WpUser wpUser) {
		
		System.out.println("Role->>>>>>" + forumService.getRole(1));
		System.out.println(wpUser.toString());
		userDetailService.save(wpUser);
		
		return "redirect:/showLoginPage";
	}
}








