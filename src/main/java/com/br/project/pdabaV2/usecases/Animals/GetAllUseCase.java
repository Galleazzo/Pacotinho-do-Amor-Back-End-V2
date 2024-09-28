package com.br.project.pdabaV2.usecases.Animals;

import br.com.backEnd.pacotinho.adapters.web.dtos.AnimalsDTO;

import java.util.List;

public interface GetAllUseCase {

    List<AnimalsDTO> getAll();
}
