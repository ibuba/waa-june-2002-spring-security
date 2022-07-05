package com.edu.miu.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService awesomeUserDetailsService;
    private final JwtFilter jwtFilter;

    @Override // specifying where  spring  should look for the users
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(awesomeUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(STATELESS);
        http .authorizeRequests()
                .antMatchers("/api/v1/uaa").permitAll()//if  authenticated access this path
                .antMatchers("/api/v1/products").hasAuthority("CLIENT")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } // tell the spring to use this type of encoder
}
