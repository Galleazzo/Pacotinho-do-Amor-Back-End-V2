package com.br.project.v2.usecases.Animals;


import com.br.project.v2.adapters.dtos.AnimalsDTO;

import java.util.List;

public interface GetAllUseCase {

    List<AnimalsDTO> getAll();
}
