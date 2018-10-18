package pl.webproject.service;

import java.util.List;
import pl.webproject.entity.ForumCategory;
import pl.webproject.entity.ForumPost;
import pl.webproject.entity.Role;

public interface ForumService {
	
	public List<ForumCategory> getForumCategories();
	public List<ForumPost> getForumPosts();
	public List<Role> getRoles();
	
	public ForumCategory getForumCategory(int id);
	public ForumPost getForumPost(int id);
	public Role getRole(int id);
	
	public void deleteForumCategory(int id);
	public void deleteForumPost(int id);
	public void deleteRole(int id);
	
	public void saveForumCategory(ForumCategory forumCategory);
	public void saveForumPost(ForumPost forumPost);
	public void saveRole(Role role);
}
