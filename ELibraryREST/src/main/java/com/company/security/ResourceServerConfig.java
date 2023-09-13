package com.company.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .resourceId("elibrary")
                .tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers()
                .and()
                .authorizeRequests().antMatchers("/admins").hasAnyAuthority("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/admin").hasAnyAuthority("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/members").hasAnyAuthority("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/member").hasAnyAuthority("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/login").permitAll()
                .and()
                .authorizeRequests().antMatchers("/book_available").hasAnyAuthority( "LIBRARY")
                .and()
                .authorizeRequests().antMatchers("/book_unavailable").hasAnyAuthority( "LIBRARY")
                .and()
                .authorizeRequests().antMatchers("/users").hasAnyAuthority( "LIBRARY")
                .and()
                .authorizeRequests().antMatchers("/user").hasAnyAuthority("LIBRARY")
                .and()
                .authorizeRequests().antMatchers("/registration").permitAll()
                .and()
                .authorizeRequests().antMatchers("/users").hasAnyAuthority("ADMIN" ,"LIBRARY")
                .and()
                .authorizeRequests().antMatchers("/libraries").hasAnyAuthority("ADMIN", "USER")
                .and()
                .authorizeRequests().antMatchers("/library_address").hasAnyAuthority("ADMIN", "USER")
                .and()
                .authorizeRequests().antMatchers("/library_name").hasAnyAuthority("ADMIN", "USER")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.DELETE, "/library").hasAnyAuthority(  "ADMIN")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST,"/library").hasAnyAuthority( "LIBRARY", "ADMIN")
                .and()
                .authorizeRequests().antMatchers("/books").hasAnyAuthority( "LIBRARY", "ADMIN")
                .and()
                .authorizeRequests().antMatchers("/book").hasAnyAuthority( "LIBRARY", "ADMIN")
                .and()

                .authorizeRequests().antMatchers("/admins").hasAnyAuthority( "ADMIN")
                .and()
                .authorizeRequests().antMatchers("/member").hasAnyAuthority(  "ADMIN")
                .and()
                .authorizeRequests().antMatchers("/member").hasAnyAuthority(  "ADMIN")
                .and()
                .authorizeRequests().antMatchers("/member").hasAnyAuthority(  "ADMIN")
                .and()
                .authorizeRequests().antMatchers("/admin").hasAnyAuthority(  "ADMIN")


                .antMatchers("/actuator/**", "/api-docs/**").permitAll()
                .antMatchers("/**" ).authenticated();
    }
}