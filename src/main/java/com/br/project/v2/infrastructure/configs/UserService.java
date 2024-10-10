package com.br.project.v2.infrastructure.configs;

import com.br.project.v2.adapters.dtos.UserDTO;
import com.br.project.v2.domain.entities.User;
import com.br.project.v2.infrastructure.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){
        User user = new User();
        if(userDTO.getId() != null)
            user.setId(userDTO.getId());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(userDTO.getPassword());

        user.setUsername(userDTO.getUsername());
        user.setPassword(password);

        return this.modelMapper.map(this.repository.save(user), UserDTO.class);
    }

    public UserDTO findById(Long id){
        User user = repository.findByIdUniq(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
