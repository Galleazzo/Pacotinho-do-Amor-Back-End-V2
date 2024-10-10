package com.br.project.v2.usecases.Animals.impl;

import com.br.project.v2.adapters.dtos.AnimalsDTO;
import com.br.project.v2.domain.entities.Animals;
import com.br.project.v2.infrastructure.repositories.AnimalsRepository;
import com.br.project.v2.usecases.Animals.GetByCriteriaUseCase;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class GetByCriteriaUseCaseImpl implements GetByCriteriaUseCase {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<AnimalsDTO> getByCriteria(String name, Integer page, Integer pageSize, String sort, String order) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sort);
        return this.modelMapper.map(this.animalsRepository.getByCriteria(name, pageable), new TypeToken<Page<Animals>>() {}.getType());
    }
}
