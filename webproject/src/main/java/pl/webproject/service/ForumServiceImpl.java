package pl.webproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.webproject.DAO.ForumDAO;
import pl.webproject.entity.ForumCategory;
import pl.webproject.entity.ForumPost;
import pl.webproject.entity.Role;

@Service
public class ForumServiceImpl implements ForumService {
	
	@Autowired
	private ForumDAO forumDAO;
	
	@Override
	@Transactional
	public List<ForumCategory> getForumCategories() {
		
		return forumDAO.getForumCategories();
	}

	@Override
	@Transactional
	public List<ForumPost> getForumPosts() {
		
		return forumDAO.getForumPosts();
	}

	
	@Override
	@Transactional
	public List<Role> getRoles() {
		
		return forumDAO.getRoles();
	}

	@Override
	@Transactional
	public ForumCategory getForumCategory(int id) {
		
		return forumDAO.getForumCategory(id);
	}

	@Override
	@Transactional
	public ForumPost getForumPost(int id) {
		
		return forumDAO.getForumPost(id);
	}

	
	@Override
	@Transactional
	public Role getRole(int id) {
		
		return forumDAO.getRole(id);
	}

	@Override
	@Transactional
	public void deleteForumCategory(int id) {
		
		forumDAO.deleteForumCategory(id);
	}

	@Override
	@Transactional
	public void deleteForumPost(int id) {
		
		forumDAO.deleteForumPost(id);
	}

	
	@Override
	@Transactional
	public void deleteRole(int id) {
		
		forumDAO.deleteRole(id);
	}

	@Override
	@Transactional
	public void saveForumCategory(ForumCategory forumCategory) {
		
		forumDAO.saveForumCategory(forumCategory);
	}

	@Override
	@Transactional
	public void saveForumPost(ForumPost forumPost) {
		
		forumDAO.saveForumPost(forumPost);
	}

	
	@Override
	@Transactional
	public void saveRole(Role role) {
		
		forumDAO.saveRole(role);
	}

}
