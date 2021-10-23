package com.example.securingWeb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
//esta anotação habilita o suporte de segurança e provê integração com Spring MVC
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//A view hello, assim como qualquer outra diferente da raiz, /home, /login e /logout, é protegida pelo Spring Security (spring-boot-starter-secutiry), que automaticamente usa segurança com autenticação básica "HTTP".
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}

	//configura um usuário em memória.
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User
			 	.withUsername("user")
			 	//o spring espera um hash, se colocar plaintext ocorrerá erro em tempo de execução.
			 	//a senha abaixo é "password" criptografado com bcrypt
				.password("{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}