package pl.webproject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.webproject.DAO.ForumDAO;
import pl.webproject.entity.Role;
import pl.webproject.entity.User;
import pl.webproject.user.WpUser;

@Service
public class UserDetailServiceImpl implements UserService {
	
	@Autowired
	ForumDAO forumDAO;
	
	@Autowired
	ForumService forumService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = forumDAO.findByUserName(userName);
		if(user == null) {
			throw new UsernameNotFoundException("zle haslo albo nazwa uzytkownika");
		}else if(user.getEnabled() == 0) {
			throw new UsernameNotFoundException("uzytkownik jest zbanowany");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public User findByUserName(String userName) {
		
		return forumDAO.findByUserName(userName);
	}
	
	@Override
	@Transactional
	public User getUser(int id) {
		return forumDAO.getUser(id);
	}

	@Override
	@Transactional
	public void save(WpUser wpUser) {
		User user = new User();
		user.setUsername(wpUser.getUserName());
		user.setPassword(passwordEncoder.encode(wpUser.getPassword()));
		user.setFirstName(wpUser.getFirstName());
		user.setLastName(wpUser.getLastName());
		user.setEmail(wpUser.getEmail());
		user.setRoles(Arrays.asList(forumService.getRole(1)));
		user.setEnabled(1);
		
		forumDAO.saveUser(user);
	}
	
	@Override
	@Transactional public void saveUser(User user) {
		forumDAO.saveUser(user);
	}
	

}
