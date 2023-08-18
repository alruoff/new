package com.example.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/registration").permitAll()    // общедоступные страницы
                .antMatchers("/authenticated/**").authenticated() // в эту область только идентиф. пользователи попадут
                .antMatchers("/admin/**").hasAnyRole("ADMIN","SUPERADMIN") // должен иметь хотя бы одну из этих ролей
                .antMatchers("/profile/**").authenticated() // в профайлы заходят только идентиф. пользователи
                .and()
                //.httpBasic() // у нас будет basic-authentication
                .formLogin()// стандартная форма для логина .loginPage("/login")
                .and()
                .logout().logoutSuccessUrl("/"); // после logout попадаем в корень
    }

}
