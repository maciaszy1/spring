package pl.webproject.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.webproject.entity.ForumCategory;
import pl.webproject.entity.ForumPost;
import pl.webproject.entity.User;
import pl.webproject.service.ForumService;
import pl.webproject.service.UserService;


@Transactional
@Controller
public class ForumController {
	
	@Autowired
	ForumService forumService;
	@Autowired
	UserService userDetailService;
	
	//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	
	@GetMapping("/")
	public String showHome(Model theModel) {
		
		List<ForumCategory> forumCategories = forumService.getForumCategories();
		theModel.addAttribute("forumCategory", forumCategories);
		
		return "home";
	}
	
	@GetMapping("/admin")
	public String showAdmin(Model theModel) {
		
		ForumCategory forumCategory = new ForumCategory();
		theModel.addAttribute("forumCategory", forumCategory);
		
		return "admin";
	}
	
	@PostMapping("/banUser")
	public String banUser(@RequestParam("userName") String userName, @ModelAttribute("user") User user){
		user = userDetailService.findByUserName(userName);
		user.setEnabled(0);
		userDetailService.saveUser(user);
		return "redirect:/";
	}

	@PostMapping("/saveForumCategory")
	public String saveForumCategory(@ModelAttribute("forumCategory") ForumCategory forumCategory) {
		
		forumService.saveForumCategory(forumCategory);
		
		return "redirect:/";
	}
	
	@GetMapping("/board")
	public String showBoard(@RequestParam("categoryId") int id, Model theModel) {
		
		ForumCategory forumCategory = forumService.getForumCategory(id);
		ForumPost forumPost = new ForumPost();
		List<ForumPost> forumPosts = forumCategory.getForumPosts();
		theModel.addAttribute("forumCategory", forumCategory);
		theModel.addAttribute("forumPosts", forumPosts);
		theModel.addAttribute("forumPost",forumPost);
		
		return "board";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(@RequestParam("categoryId") int id) {
			
		forumService.deleteForumCategory(id);
		return "home";
	}
	
	@GetMapping("/deletePost")
	public String deletePost(@RequestParam("postId") int id) {
		
		forumService.deleteForumPost(id);
		return "home";
	}
	
	@PostMapping("/saveForumPost{someId}")
	public String saveForumPost(Principal principal, @ModelAttribute("forumUser") User user,@ModelAttribute("forumPost") ForumPost forumPost, @ModelAttribute("forumCategory") ForumCategory oldForumCategory, @PathVariable(value="someId") String someId) {
		
		oldForumCategory = forumService.getForumCategory(Integer.parseInt(someId));
		user = userDetailService.findByUserName(principal.getName());
		forumPost.setUser(user);
		user.setForumPost(forumPost);
		oldForumCategory.addPost(forumPost);
		forumPost.setForumCategory(oldForumCategory);
		userDetailService.saveUser(user);
		forumService.saveForumPost(forumPost);
		forumService.saveForumCategory(oldForumCategory);
		
		return "redirect:/board?categoryId={someId}";
	}

}
