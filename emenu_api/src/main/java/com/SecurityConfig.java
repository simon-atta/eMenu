// package com;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
//
/// **
// * This is security config which contains all security for API.
// *
// * @author Simon Ghobreil
// */
// @Configuration
// public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
// @Override
// protected void configure(HttpSecurity http) throws Exception {
// http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET,
// "/api/**").authenticated()
// .antMatchers(HttpMethod.PUT,
// "/api/**").authenticated().antMatchers(HttpMethod.POST, "/api/**")
// .authenticated().anyRequest().permitAll().and().httpBasic().and().sessionManagement()
// .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// }
//
// }
