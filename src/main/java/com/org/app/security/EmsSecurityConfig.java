//package com.org.app.security;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class EmsSecurityConfig {
//    
//    // Retirieving users and roles from db
//	
//    @Bean
//    UserDetailsManager userDetailsManager(DataSource dataSource) {
//    	
//    	return new JdbcUserDetailsManager(dataSource);
//    }
//    
//    // Restrict access based http method and endpoints
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    	http.authorizeHttpRequests(configurer -> configurer
//    			.requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("EMPLOYEE")
//    			.requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("EMPLOYEE")
//    			.requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("MANAGER")
//    			.requestMatchers(HttpMethod.PUT, "/api/employees").hasAnyRole("MANAGER")
//    			.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
//    			);
//    	
//    	// Use http basic authentication
//    	http.httpBasic(Customizer.withDefaults());
//    	
//    	// Disable CSRF
//    	http.csrf(csrf -> csrf.disable());
//    	
//    	return http.build();
//    }
//    
//
//	// add users in application memory
////  @Bean
////  InMemoryUserDetailsManager userDetailsManager() {
////		
////		UserDetails john = User.builder()
////				.username("john")
////				.password("{noop}john@123")
////				.roles("EMPLOYEE")
////				.build();
////		
////		UserDetails mary = User.builder()
////				.username("mary")
////				.password("{noop}mary@123")
////				.roles("EMPLOYEE", "MANAGER")
////				.build();
////		
////		UserDetails sam = User.builder()
////				.username("sam")
////				.password("{noop}sam@123")
////				.roles("EMPLOYEE", "MANAGER", "ADMIN")
////				.build();
////		
////		return new InMemoryUserDetailsManager(john, mary, sam);
////	}
//    
//}
