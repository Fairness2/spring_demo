package ru.geekbrains.spring_demo_core_lib.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.geekbrains.spring_demo_core_lib.classes.JwtPayload;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Имплементация деталей пользователя для своей авторизации по токену
 */
@Data
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {
    /**
     * Роль которую мы раздадим всем авторизованным пользователям
     */
    private static final String defaultRole = "USER";
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    /**
     * Создаём детальки из пэйлоада в токене
     * @param payload
     */
    public CustomUserDetails(JwtPayload payload) {
        this.username = payload.getUsername();
        List<SimpleGrantedAuthority> rightList = payload.getRights()
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        rightList.add(new SimpleGrantedAuthority(defaultRole));
        this.grantedAuthorities = rightList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
