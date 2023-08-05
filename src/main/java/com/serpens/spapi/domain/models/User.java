package com.serpens.spapi.domain.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "users")
@AllArgsConstructor
@RequiredArgsConstructor
public class User extends BaseModel implements UserDetails {
    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO check if it is expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO check if it is locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO check if credentials are expired
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}



