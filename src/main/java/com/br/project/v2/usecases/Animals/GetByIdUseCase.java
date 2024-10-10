package com.br.project.v2.usecases.Animals;

import com.br.project.v2.adapters.dtos.AnimalsDTO;

public interface GetByIdUseCase {

    AnimalsDTO getById(Long id) throws Exception;
}
