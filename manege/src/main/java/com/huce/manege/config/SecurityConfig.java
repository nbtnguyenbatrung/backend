//
//package com.huce.manege.config;
//
//import com.huce.manege.filter.ApiKeyAuthenticationFilter;
//import com.huce.manege.provider.ApiKeyAuthenticationProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
//
//import java.util.Collections;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private ApiKeyAuthenticationProvider apiKeyAuthenticationProvider;
//
//    @Autowired
//    public SecurityConfig(ApiKeyAuthenticationProvider apiKeyAuthenticationProvider) {
//        this.apiKeyAuthenticationProvider = apiKeyAuthenticationProvider;
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .addFilterBefore(
//                        new ApiKeyAuthenticationFilter(authenticationManager()),
//                        AnonymousAuthenticationFilter.class).csrf().disable();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager() {
//        return new ProviderManager(Collections.singletonList(apiKeyAuthenticationProvider));
//    }
//    /*@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth){
//        try {
//            auth.inMemoryAuthentication()
//                    .withUser("user").password("{noop}user").roles("USER")
//                    .and()
//                    .withUser("admin").password("{noop}admin").roles("ADMIN");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                // tắt bảo mật
//                .authorizeRequests()
//                .antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable();
//
//                // tạo bảo mật
//                *//*.httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/*").hasRole("ADMIN")
//                .and()
//                .csrf().disable()
//                .formLogin().disable();*//*
//                *//*.authorizeRequests()
//                .antMatchers("/h2-console/**").permitAll().and().csrf().ignoringAntMatchers("/h2-console/**")
//                .and().headers().frameOptions().sameOrigin().and().formLogin();*//*
//
//
//    }*/
//
//}
