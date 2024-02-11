package com.App.Documentation.SNPC.security;

import com.App.Documentation.SNPC.exception.AUthEntrypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

public class SecurityConfig {
    @Autowired
    private AUthEntrypoint aUthEntrypoint;
    @Autowired
    private AuthenticationFilter authenticationFilter;
    @Autowired
    private  final UserDetailsService userDetailsService;


    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
}
