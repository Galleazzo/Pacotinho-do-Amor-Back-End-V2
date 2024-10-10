package com.br.project.v2.usecases.authenticator;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoadUserByUsernameUseCase extends UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
