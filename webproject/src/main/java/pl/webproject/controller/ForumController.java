package pl.webproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.webproject.entity.ForumCategory;
import pl.webproject.entity.ForumPost;
import pl.webproject.service.ForumService;

@Controller
public class ForumController {
	
	@Autowired
	ForumService forumService;
	
	
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

	@PostMapping("/saveForumCategory")
	public String saveForumCategory(@ModelAttribute("forumCategory") ForumCategory forumCategory) {
		
		forumService.saveForumCategory(forumCategory);
		
		return "redirect:/";
	}
	
	@GetMapping("/board")
	public String showBoard(@RequestParam("categoryId") int id, Model theModel) {
		
		ForumCategory forumCategory = forumService.getForumCategory(id);
		List<ForumPost> forumPosts = forumCategory.getForumPosts();
		theModel.addAttribute("forumCategory", forumCategory);
		theModel.addAttribute("forumPosts", forumPosts);
		
		return "board";
	}
	
	@PostMapping("/saveForumPost")
	public String saveForumPost(@ModelAttribute("forumPost") ForumPost forumPost) {
		
		forumService.saveForumPost(forumPost);
		
		return "redirect:/";
	}

}
