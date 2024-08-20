package com.mindhub.todolist.infrastructure.auth.config;

import com.mindhub.todolist.domain.user.port.dao.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserDao userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        System.out.println("CustomUserDetailsService:  " + user.getUsername());
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
//        UserEntity userEntity = userRepository.findByUserName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//
//        return new User(userEntity.getUserName(), userEntity.getPassword(), AuthorityUtils.createAuthorityList(
//                userEntity.getRol().toString()
//        ));
    }
}