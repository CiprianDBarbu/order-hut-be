package com.cbar.orderhutbe.service;

import com.cbar.orderhutbe.exceptions.NoElementFoundException;
import com.cbar.orderhutbe.model.User;
import com.cbar.orderhutbe.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getGrantedAuthority(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthority(User user) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if(user.getRole().equalsIgnoreCase("admin")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if(user.getRole().equalsIgnoreCase("waiter")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_WAITER"));
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return authorities;
    }

    public User retrieveUserById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoElementFoundException("Id not available!"));
    }
}
