package com.br.project.pdabaV2.usecases.Animals;

import br.com.backEnd.pacotinho.adapters.web.dtos.AnimalsDTO;

public interface GetByIdUseCase {

    AnimalsDTO getById(Long id) throws Exception;
}
