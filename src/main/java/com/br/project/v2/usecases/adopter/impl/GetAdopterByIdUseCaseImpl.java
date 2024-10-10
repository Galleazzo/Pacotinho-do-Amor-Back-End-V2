package com.br.project.v2.usecases.adopter.impl;

import com.br.project.v2.adapters.dtos.AdopterDTO;
import com.br.project.v2.domain.entities.Adopter;
import com.br.project.v2.infrastructure.repositories.AdopterRepository;
import com.br.project.v2.usecases.adopter.GetAdopterById;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class GetAdopterByIdUseCaseImpl implements GetAdopterById {

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AdopterDTO getAdopterById(Long id) {
        Adopter adopter = adopterRepository.findById(id).orElseThrow(() -> new RuntimeException("Adopter not found with id " + id));
        return modelMapper.map(adopter, AdopterDTO.class);
    }
}
