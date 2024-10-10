package com.br.project.v2.usecases.Animals.impl;

import com.br.project.v2.infrastructure.repositories.AnimalsRepository;
import com.br.project.v2.usecases.Animals.DeleteAnimalUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAnimalUseCaseImpl implements DeleteAnimalUseCase {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Override
    public void deleteAnimal(Long id) throws Exception {
        try {
            this.animalsRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Erro ao deletar o animal: " + e.getMessage());
        }
    }
}
