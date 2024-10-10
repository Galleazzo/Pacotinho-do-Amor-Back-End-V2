package com.br.project.v2.usecases.adopter.impl;

import com.br.project.v2.adapters.dtos.AdopterDTO;
import com.br.project.v2.domain.entities.Adopter;
import com.br.project.v2.infrastructure.repositories.AdopterRepository;
import com.br.project.v2.usecases.adopter.CreateAdopterUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CreateAdopterUseCaseImpl implements CreateAdopterUseCase {

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public AdopterDTO createAdopter(AdopterDTO adopterDTO) {
        Adopter adopter = modelMapper.map(adopterDTO, Adopter.class);
        Adopter savedAdopter = adopterRepository.save(adopter);
        return modelMapper.map(savedAdopter, AdopterDTO.class);
    }
}
