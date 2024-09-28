package com.br.project.pdabaV2.usecases.adopter.impl;

import com.br.project.pdabaV2.adapters.dtos.AdopterDTO;
import com.br.project.pdabaV2.domain.entities.Adopter;
import com.br.project.pdabaV2.domain.entities.Animals;
import com.br.project.pdabaV2.infrastructure.repositories.AdopterRepository;
import com.br.project.pdabaV2.infrastructure.repositories.AnimalsRepository;
import com.br.project.pdabaV2.usecases.adopter.AdoptAnimalUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AdoptAnimalUseCaseImpl implements AdoptAnimalUseCase {

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private AnimalsRepository animalsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public AdopterDTO adoptAnimal(Long adopterId, Long animalId) {
        Adopter adopter = adopterRepository.findById(adopterId).orElseThrow(() -> new RuntimeException("Adopter not found with id " + adopterId));
        Animals animal = animalsRepository.findById(animalId).orElseThrow(() -> new RuntimeException("Animal not found with id " + animalId));

        adopter.getAnimals().add(animal);

        if (animal.getAdopterPeople().size() < 2) {
            animal.getAdopterPeople().add(adopter);
        } else {
            throw new RuntimeException("Animal already has maximum number of adopters");
        }

        animalsRepository.save(animal);
        Adopter savedAdopter = adopterRepository.save(adopter);

        return modelMapper.map(savedAdopter, AdopterDTO.class);
    }
}
