package pl.webproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity

public class WebProjectSecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	
	UserBuilder user = User.withDefaultPasswordEncoder();
	
	auth.inMemoryAuthentication()
								.withUser(user.username("test").password("test123").roles("ADMIN"))
								.withUser(user.username("guest").password("test123").roles("GUEST"));
								
	}
}
