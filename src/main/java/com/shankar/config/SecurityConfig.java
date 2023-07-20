package com.shankar.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Autowired
	private DataSource dataSource;
	

	
@Autowired
public void authManager(AuthenticationManagerBuilder auth) throws Exception
{
 auth.jdbcAuthentication()
 .dataSource(dataSource)
 .passwordEncoder(new BCryptPasswordEncoder())
 .usersByUsernameQuery("select username,password,enable from users where username=?")
 .authoritiesByUsernameQuery("select username,autority from authorities where username=?");
	
}



@Bean
public SecurityFilterChain securityFile(HttpSecurity http)throws Exception
{
	http.authorizeHttpRequests((request)->request
	   .antMatchers("/","/login", "/about").permitAll()
	   .anyRequest().authenticated()

	).formLogin();
			
		return http.build();	
}

}
