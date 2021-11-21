
package com.huce.manege.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth){
        try {
            auth.inMemoryAuthentication()
                    .withUser("user").password("{noop}user").roles("USER")
                    .and()
                    .withUser("admin").password("{noop}admin").roles("ADMIN");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // tắt bảo mật
                .authorizeRequests()
                .antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable();

                // tạo bảo mật
                /*.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/*").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();*/
                /*.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll().and().csrf().ignoringAntMatchers("/h2-console/**")
                .and().headers().frameOptions().sameOrigin().and().formLogin();*/


    }

}
