package com.br.project.v2.usecases.authenticator.impl;

import com.br.project.v2.infrastructure.repositories.UserRepository;
import com.br.project.v2.usecases.authenticator.LoadUserByUsernameUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoadUserByUsernameUseCaseImpl implements LoadUserByUsernameUseCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            return this.userRepository.findByUsername(username);
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
