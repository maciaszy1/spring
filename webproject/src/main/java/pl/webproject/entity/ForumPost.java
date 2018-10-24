package pl.webproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="forum_post")
public class ForumPost {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_post")
	private int id;
	/*
	@OneToOne(mappedBy = "forumPost", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	*/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_user")
	User user;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@ManyToOne
	@JoinColumn(name="id_category")
	private ForumCategory forumCategory;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public ForumCategory getForumCategory() {
		return forumCategory;
	}

	public void setForumCategory(ForumCategory forumCategory) {
		this.forumCategory = forumCategory;
	}

	@Override
	public String toString() {
		return "ForumPost [id=" + id + ", user=" + user + ", title=" + title
				+ ", content=" + content + "]";
	}
	
	
}
