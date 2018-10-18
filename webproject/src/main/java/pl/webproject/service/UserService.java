package pl.webproject.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import pl.webproject.entity.User;
import pl.webproject.user.WpUser;

public interface UserService extends UserDetailsService {
	
	User findByUserName(String userName);
	
	void save(WpUser wpUser);
	
	void saveUser(User user);
	
	User getUser(int id);

}
