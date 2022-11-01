package ru.geekbrains.spring_demo_auth_ms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import ru.geekbrains.spring_demo_core_lib.config.CommonSecurityConfig;

/**
 * Конфиг авторизации
 */
@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends CommonSecurityConfig {

    /**
     * Указываем заблокированные пути
     * @param http
     * @throws Exception
     */
    @Override
    protected void configurePaths(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/auth/*").anonymous()
                .antMatchers("/**").authenticated()
                .anyRequest().permitAll();
    }
}
