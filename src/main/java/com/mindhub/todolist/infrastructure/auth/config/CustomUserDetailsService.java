package com.mindhub.todolist.infrastructure.auth.config;

import com.mindhub.todolist.domain.user.port.dao.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserDao userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRol().getName());
        return new User(user.getUsername(), user.getPassword(), Collections.singletonList(authority));
    }
}