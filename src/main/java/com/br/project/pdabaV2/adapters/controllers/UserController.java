package com.br.project.pdabaV2.adapters.controllers;

import br.com.backEnd.pacotinho.adapters.web.dtos.UserDTO;

public interface UserController {

    void saveUser(UserDTO user);

    UserDTO findById(Long id);
}
