package com.br.project.pdabaV2.usecases.adopter;

import com.br.project.pdabaV2.adapters.dtos.AdopterDTO;

public interface AdoptAnimalUseCase {

    public AdopterDTO adoptAnimal(Long adopterId, Long animalId);
}
