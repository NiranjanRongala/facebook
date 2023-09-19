package com.example.facebook3.Security;

import com.example.facebook3.ServicesImp.UserServiceImp;
//import com.img.securityjwt.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserServiceImp();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf(csrf->csrf.disable())
//                .cors().and()
//                .authorizeHttpRequests(auth->auth.requestMatchers("/**").permitAll())
//                .authorizeHttpRequests(auth->auth.requestMatchers("/users","/user","/posts","/user-id/100/password/user_1").authenticated())
//                //.authorizeHttpRequests(auth->auth.requestMatchers("/**").permitAll())
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and().httpBasic().and().build();
//    }
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http.csrf().disable()
            .cors().and()
            .authorizeHttpRequests()
            .requestMatchers( "/users1","/comment-id/{comment-id}/comment/{comment}").authenticated()
            .and()
            .authorizeHttpRequests().requestMatchers("/**").permitAll()
            .and().httpBasic()
            //.and().formLogin()
            .and().build();

}



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthProvider=new DaoAuthenticationProvider();
        daoAuthProvider.setUserDetailsService(userDetailsService());
        daoAuthProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthProvider;
    }
}
