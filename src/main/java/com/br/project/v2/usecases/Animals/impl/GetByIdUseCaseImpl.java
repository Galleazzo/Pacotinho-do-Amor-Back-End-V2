package com.br.project.v2.usecases.Animals.impl;

import com.br.project.v2.adapters.dtos.AnimalsDTO;
import com.br.project.v2.domain.entities.Animals;
import com.br.project.v2.infrastructure.repositories.AnimalsRepository;
import com.br.project.v2.usecases.Animals.GetByIdUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class GetByIdUseCaseImpl implements GetByIdUseCase {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AnimalsDTO getById(Long id) throws Exception {
        Animals animal = this.animalsRepository.getById(id);
        return this.modelMapper.map(animal, AnimalsDTO.class);
    }
}
