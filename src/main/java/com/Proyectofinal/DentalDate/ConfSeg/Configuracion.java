/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Proyectofinal.DentalDate.ConfSeg;

import com.Proyectofinal.DentalDate.Service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Configuracion extends WebSecurityConfigurerAdapter {
    

    @Autowired
    private UsuarioServicio us;
    
   
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       
        auth.userDetailsService(us)
       
            .passwordEncoder(new BCryptPasswordEncoder());
    }
    
     String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
            };
            
    
     @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(resources).permitAll()
                .antMatchers("/","/index").permitAll()
	        .antMatchers("/admin*").access("hasRole('ADMIN')")
	        .antMatchers("/user*").access("hasRole('USER')")
                .and().formLogin()                                                            
                        .loginPage("/login") 
                        .loginProcessingUrl("/logincheck")
                        .usernameParameter("email") 
                        .passwordParameter("password") 
                        .defaultSuccessUrl("/index").permitAll() 
                .and().logout() 
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout").permitAll()
                .and().csrf().disable();
    }
    
    
    
    
}

