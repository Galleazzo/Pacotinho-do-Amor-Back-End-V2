package com.br.project.v2.adapters.controllers.impl;

import com.br.project.v2.adapters.controllers.AuthenticationController;
import com.br.project.v2.adapters.dtos.UserDTO;
import com.br.project.v2.adapters.dtos.tokenDTO;
import com.br.project.v2.domain.entities.User;
import com.br.project.v2.infrastructure.configs.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationControllerImpl implements AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Override
    @PostMapping(path = "/login", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) throws Exception{
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        Authentication authentication =  this.authenticationManager.authenticate(authenticationToken);

        String tokenJWT = this.tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new tokenDTO(tokenJWT));
    }

    @Override
    @GetMapping("/checkToken")
    public ResponseEntity<Boolean> checkTokenValidity(@RequestParam("token") String token) {
        try {
            boolean isValid = tokenService.cheakValidToken(token);
            return ResponseEntity.ok(isValid);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
    }
}
