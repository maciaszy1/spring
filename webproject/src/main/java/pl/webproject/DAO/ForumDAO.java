package pl.webproject.DAO;

import java.util.List;

import pl.webproject.entity.ForumCategory;
import pl.webproject.entity.ForumPost;
import pl.webproject.entity.Role;
import pl.webproject.entity.User;

public interface ForumDAO {
	
	public List<ForumCategory> getForumCategories();
	public List<ForumPost> getForumPosts();
	public List<User> getUsers();
	public List<Role> getRoles();
	
	public ForumCategory getForumCategory(int id);
	public ForumPost getForumPost(int id);
	public User getUser(int id);
	public Role getRole(int id);
	
	public void deleteForumCategory(int id);
	public void deleteForumPost(int id);
	public void deleteUser(String username);
	public void deleteRole(int id);
	
	public void saveForumCategory(ForumCategory forumCategory);
	public void saveForumPost(ForumPost forumPost);
	public void saveUser(User user);
	public void saveRole(Role role);
	
	public User findByUserName(String userName);
	
}
