package com.br.project.v2.adapters.controllers;


import com.br.project.v2.adapters.dtos.UserDTO;

public interface UserController {

    void saveUser(UserDTO user);

    UserDTO findById(Long id);
}
