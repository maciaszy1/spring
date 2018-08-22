package pl.webproject.DAO;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import pl.webproject.entity.ForumCategory;
import pl.webproject.entity.ForumPost;

public interface ForumDAO {
	
	public List<ForumCategory> getForumCategories();
	public List<ForumPost> getForumPosts();
	public List<User> getUsers();
	
	public ForumCategory getForumCategory(int id);
	public ForumPost getForumPost(int id);
	public User getUser(int id);
	
	public void deleteForumCategory(int id);
	public void deleteForumPost(int id);
	public void deleteUser(int id);
	
	public void saveForumCategory(ForumCategory forumCategory);
	public void saveForumPost(ForumPost forumPost);
	public void saveUser(User user);
	
}
