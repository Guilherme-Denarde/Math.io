//package com.uniamerida.estadistica.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig  {
//    @Bean
//    public void configure(final HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.headers().httpStrictTransportSecurity().disable();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        // Authorize sub-folders permissions
//        http.antMatcher(uri).authorizeRequests().anyRequest().permitAll();
//    }
//}
