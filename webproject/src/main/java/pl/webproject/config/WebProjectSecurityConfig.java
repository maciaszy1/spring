package pl.webproject.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import pl.webproject.service.UserService;

@Configuration
@EnableWebSecurity
public class WebProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource myDataSource;
	
	@Autowired
	CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired 
	UserService userDetailsService;
	//W razie problemów z baz¹ mo¿na ustawiæ logowanie "reczne"
	/*
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	
	UserBuilder user = User.withDefaultPasswordEncoder();
	
	auth.inMemoryAuthentication()
								.withUser(user.username("test").password("test123").roles("ADMIN","USER"))
								.withUser(user.username("guest").password("test123").roles("GUEST","USER"));
								
	}
	*/
	// ustawienie autentykacji na podstawie loadUser? Oraz dodanie kodowania/dekodowanie bcrypt hasel
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userDetailsService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	//uyzcie wzyej skonfigurowanej autentykacji
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests()
			.antMatchers("/").hasRole("USER")
			.antMatchers("/admin").hasRole("ADMIN")
			.and()
			.formLogin()
			.loginPage("/showLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.successHandler(customAuthenticationSuccessHandler) //klasa konfiguracyjna sukcesu logowania
			.permitAll()
			.and()
			.logout()
			.permitAll()
			.and()
			.exceptionHandling()
			.accessDeniedPage("/accessDenied");	
	}
}
