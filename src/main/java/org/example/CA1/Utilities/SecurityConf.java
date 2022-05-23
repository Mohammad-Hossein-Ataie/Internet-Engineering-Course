//package org.example.CA1.Utilities;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConf extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**")
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll();
//        http.csrf().disable();
//        http.logout().disable();
//        http.formLogin().disable();
//    }
//
//}
