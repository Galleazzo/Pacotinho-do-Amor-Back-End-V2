package com.br.project.pdabaV2.usecases.Animals;

import br.com.backEnd.pacotinho.adapters.web.dtos.AnimalsDTO;

public interface SaveUseCase {

    AnimalsDTO save(AnimalsDTO animalsDTO);
}
