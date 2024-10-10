package com.br.project.v2.usecases.adopter;

import com.br.project.v2.adapters.dtos.AdopterDTO;
import org.springframework.stereotype.Service;

public interface AdoptAnimalUseCase {

    public AdopterDTO adoptAnimal(Long adopterId, Long animalId);
}
