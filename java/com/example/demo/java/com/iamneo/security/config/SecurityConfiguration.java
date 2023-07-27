package com.iamneo.security.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;
@Configuration@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {   
	private final JwtAuthenticationFilter jwtAuthFilter;

	private final AuthenticationProvider authenticationProvider;
	    @Bean   
	    public CorsConfigurationSource corsConfigurationSource(){  
	    	CorsConfiguration configuration =new CorsConfiguration();     
	    	configuration.addAllowedOrigin("*");    
	    	configuration.addAllowedMethod("*");   
	    	configuration.addAllowedHeader("*"); 
	    	UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();  
	    	source.registerCorsConfiguration("/**", configuration);   
	    	return source;    } 
	    @Bean    
	    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {  
	    	httpSecurity     
	    	.cors()
	    	.and()
	    	.csrf()           
	    	.disable()          
	    	.authorizeHttpRequests()       
	    	.requestMatchers("/api/v1/auth/**") 
	    	.permitAll()              
	    	.anyRequest()             
	    	.authenticated()          
	    	.and()           
	    	.sessionManagement()     
	    	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)  
	    	.and()        
	    	.authenticationProvider(authenticationProvider) 
	    	.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); 


	    	return httpSecurity.build();

	    	}
	    

	    	}