package pl.webproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="forum_category")
public class ForumCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_category")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy="forumCategory", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ForumPost> forumPosts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<ForumPost> getForumPosts() {
		return forumPosts;
	}

	public void setForumPost(List<ForumPost> forumPosts) {
		this.forumPosts = forumPosts;
	}

	@Override
	public String toString() {
		return "ForumCategory [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
	public List<ForumPost> addPost(ForumPost forumPost) {
		List<ForumPost> newList = forumPosts;
		newList.add(forumPost);
		return newList;
	}
	
	
}
