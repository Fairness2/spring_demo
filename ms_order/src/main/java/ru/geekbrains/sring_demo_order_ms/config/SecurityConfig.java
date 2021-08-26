package ru.geekbrains.sring_demo_order_ms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import ru.geekbrains.spring_demo_core_lib.config.CommonSecurityConfig;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends CommonSecurityConfig {

    @Override
    protected void configurePaths(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").authenticated()
                .anyRequest().permitAll();
    }
}
