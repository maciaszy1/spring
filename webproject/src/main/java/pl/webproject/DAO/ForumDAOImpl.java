package pl.webproject.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import pl.webproject.entity.ForumCategory;
import pl.webproject.entity.ForumPost;

@Repository
public class ForumDAOImpl implements ForumDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ForumCategory> getForumCategories() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<ForumCategory> query = currentSession.createQuery("from ForumCategory order by title", ForumCategory.class);
		
		List<ForumCategory> forumCategories = query.getResultList();
		
		return forumCategories;
	}

	@Override
	public List<ForumPost> getForumPosts() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<ForumPost> query = currentSession.createQuery("from ForumPost order by title");
		
		List<ForumPost> forumPosts = query.getResultList();
		
		return forumPosts;
	}

	@Override
	public List<User> getUsers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> query = currentSession.createQuery("from User order by username");
		
		List<User> users = query.getResultList();
		
		return users;
	}

	@Override
	public ForumCategory getForumCategory(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		ForumCategory theForumCategory = currentSession.get(ForumCategory.class, id);
		
		return theForumCategory;
	}

	@Override
	public ForumPost getForumPost(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		ForumPost theForumPost = currentSession.get(ForumPost.class, id);
		
		return theForumPost;
	}

	@Override
	public User getUser(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		User theUser = currentSession.get(User.class, id);
		
		return theUser;
	}

	@Override
	public void deleteForumCategory(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("delete from ForumCategory where id=:id");
		query.setParameter("id", id);
		
		query.executeUpdate();

	}

	@Override
	public void deleteForumPost(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("delete from ForumPost where id=:id");
		query.setParameter("id", id);
		
		query.executeUpdate();
		
	}

	@Override
	public void deleteUser(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("delete from User where id=:id");
		query.setParameter("id", id);
		
		query.executeUpdate();

	}

	@Override
	public void saveForumCategory(ForumCategory forumCategory) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(forumCategory);

	}

	@Override
	public void saveForumPost(ForumPost forumPost) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(forumPost);

	}

	@Override
	public void saveUser(User user) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(user);

	}

}
