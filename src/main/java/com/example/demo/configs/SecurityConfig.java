package com.example.demo.configs;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
//    @Autowired
//    public void setUserDetailsService(UserService userService) {
//        this.userService = userService;
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/", "/registration").hasRole("USER")    // только для USER
                .antMatchers("/authenticated/**").authenticated() // только идентиф. пользователи
                .antMatchers("/view").hasAnyRole("MANAGER", "USER")
                .antMatchers("/","/admin/**","/newcustomer").hasAnyRole("ADMIN") // может быть несколько ролей
                .antMatchers("/profile/**").authenticated() // в профайлы заходят только идентиф. пользователи
                .antMatchers("/users").authenticated()
                .anyRequest().permitAll() // все прочие запросы общедоступны
                .and()
                //.httpBasic() // у нас будет basic-authentication
                .formLogin()// стандартная форма для логина .loginPage("/login")
                .and()
                .logout().logoutSuccessUrl("/"); // после logout попадаем в корень

        http.csrf().disable(); // разрешаем POST-запросы без _csrf
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder( passwordEncoder() );
        authProvider.setUserDetailsService(userService);
        return authProvider;
    }
}
