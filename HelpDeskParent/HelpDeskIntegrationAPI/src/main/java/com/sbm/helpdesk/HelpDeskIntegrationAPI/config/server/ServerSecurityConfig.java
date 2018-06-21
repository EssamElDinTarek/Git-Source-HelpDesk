package com.sbm.helpdesk.HelpDeskIntegrationAPI.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sbm.helpdesk.HelpDeskIntegrationAPI.config.encryption.Encoders;

@Configuration
@EnableWebSecurity
@Import(Encoders.class)
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder userPasswordEncoder;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(userPasswordEncoder);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	// TODO Auto-generated method stub
    	 http.
         authorizeRequests()
             .antMatchers("/","/api/user/login/", "/resources/**")
                 .permitAll()
             .and()
             .formLogin()
                 .loginPage("/")
                 .loginProcessingUrl("/login")
                 .and()
                 .csrf().disable()
                 .logout()
                     .logoutSuccessUrl("/")
                     .logoutUrl("/logout").and().userDetailsService(userDetailsService);
    }
    
}