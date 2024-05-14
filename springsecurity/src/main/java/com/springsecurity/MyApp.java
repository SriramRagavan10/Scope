package com.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyApp extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		auth.inMemoryAuthentication().withUser("SriRaji")
//				.password("$2a$12$DuV9dwWeg8VKABBR6xPiSOK8StbRelfpX.mLnUc6QVV/koLZ6c7B.").roles("student");
//	}

//	@Bean
//	public PasswordEncoder pass() {
//		return NoOpPasswordEncoder.getInstance();
//	}

//	@Bean
//	public PasswordEncoder pass() {
//		return new BCryptPasswordEncoder(12);
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("SriRaji")
				.password("$2a$10$Y0BJND4EQBnOtaLR2d9JQO/hOdCPM7YadYwK5Pyj39GTLTWlgp/5K").roles("student").and()
				.withUser("Raji").password("$2a$10$dt.vdIzJumq5hQLOvnUmH.elwK1ueYlf/fvks/F3MI8z2buUXV1kC")
				.roles("trainer").and().withUser("Sriram")
				.password("$2a$10$9hppFqIBK06Y9j.wFC/PweRRwSJc/cmAaYfMPa7q6mxv55yu.hP5C").roles("manager");
	}

	@Bean
	public PasswordEncoder pass() {
		return new BCryptPasswordEncoder(10);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeHttpRequests().antMatchers("/getManager").hasRole("manager");
		http.authorizeHttpRequests().antMatchers("/getTrainer").hasAnyRole("trainer", "manager");
		http.authorizeHttpRequests().antMatchers("/getStudent").hasAnyRole("trainer", "manager", "student").and()
				.formLogin();
	}

}
