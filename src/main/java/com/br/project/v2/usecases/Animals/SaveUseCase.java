package com.br.project.v2.usecases.Animals;

import com.br.project.v2.adapters.dtos.AnimalsDTO;

public interface SaveUseCase {

    AnimalsDTO save(AnimalsDTO animalsDTO);
}
