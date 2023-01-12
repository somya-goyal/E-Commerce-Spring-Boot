//package com.ecommerce.shoppingapp.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@EnableWebSecurity
//public class SecurityConfiguration{
//	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService()
//	{
//		UserDetails user=User.withDefaultPasswordEncoder()
//				.username("somya")
//				.password("goyal")
//				.roles("user")
//				.build();
//		UserDetails seller=User.withDefaultPasswordEncoder()
//				.username("rajesh")
//				.password("rajesh")
//				.roles("seller")
//				.build();
//		return new InMemoryUserDetailsManager(user,seller);
//	}
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
//	{
//		http.authorizeRequests()
//		.antMatchers("/seller/**","/product/**").hasRole("seller")
//		.antMatchers("/user/**","/product/search/**").hasRole("user")
//		.and().formLogin();
//		return http.build();
//	}
//}
