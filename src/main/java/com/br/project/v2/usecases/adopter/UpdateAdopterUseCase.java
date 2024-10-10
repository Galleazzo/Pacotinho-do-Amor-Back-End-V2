package com.br.project.v2.usecases.adopter;

import com.br.project.v2.adapters.dtos.AdopterDTO;

public interface UpdateAdopterUseCase {

    AdopterDTO updateAdopter(Long id, AdopterDTO updatedAdopterDTO);
}
