package com.App.Documentation.SNPC.service;

import com.App.Documentation.SNPC.entity.User;
import com.App.Documentation.SNPC.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserServiceImplementation implements UserDetailsService {
    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.springframework.security.core.userdetails.User.UserBuilder builder=null ;
        Optional<User> user=userRepository.findUserByUsername(username);
        if (user.isPresent()){
            User currentUser=user.get();
            builder=org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(currentUser.getPassword());
            builder.roles(currentUser.getRole());
        }else {
            throw new UsernameNotFoundException("User Not found");
        }
        return builder.build();
    }
}
