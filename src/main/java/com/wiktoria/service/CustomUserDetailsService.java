package com.wiktoria.service;

import com.wiktoria.model.User;
import com.wiktoria.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if(user==null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> authorityList = new ArrayList<>();

        return org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorityList);
    }
}
