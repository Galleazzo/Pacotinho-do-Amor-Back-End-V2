package com.br.project.v2.adapters.controllers;

import com.br.project.v2.adapters.dtos.UserDTO;
import org.springframework.http.ResponseEntity;

public interface AuthenticationController {

    ResponseEntity<?> login(UserDTO userDTO) throws Exception;

    ResponseEntity<Boolean> checkTokenValidity(String token);
}
