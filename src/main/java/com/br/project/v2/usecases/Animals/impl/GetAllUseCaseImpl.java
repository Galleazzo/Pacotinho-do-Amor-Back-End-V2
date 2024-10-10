package com.br.project.v2.usecases.Animals.impl;

import com.br.project.v2.adapters.dtos.AnimalsDTO;
import com.br.project.v2.domain.entities.Animals;
import com.br.project.v2.infrastructure.repositories.AnimalsRepository;
import com.br.project.v2.usecases.Animals.GetAllUseCase;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;
import java.util.List;

public class GetAllUseCaseImpl implements GetAllUseCase {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AnimalsDTO> getAll() {
        List<Animals> animalsList = this.animalsRepository.findAll();
        Type listType = new TypeToken<List<AnimalsDTO>>() {}.getType();
        return this.modelMapper.map(animalsList, listType);
    }
}
