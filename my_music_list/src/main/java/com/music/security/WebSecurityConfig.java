package com.music.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// disable caching
	    http.headers().cacheControl();
	    // disable csrf for our requests.
	    http.csrf().disable().authorizeRequests()
		   .antMatchers("/").permitAll()
	       .antMatchers("/api/**").permitAll()
	       .antMatchers("/music/**").permitAll()
	       .anyRequest().authenticated()
           .and()
           .addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class)
           .sessionManagement()
           .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
