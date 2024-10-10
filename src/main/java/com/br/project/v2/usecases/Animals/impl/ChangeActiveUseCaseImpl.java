package com.br.project.v2.usecases.Animals.impl;

import com.br.project.v2.domain.entities.Animals;
import com.br.project.v2.infrastructure.repositories.AnimalsRepository;
import com.br.project.v2.usecases.Animals.ChangeActiveUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ChangeActiveUseCaseImpl implements ChangeActiveUseCase {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Override
    public void changeActive(Long id, Date adoptionDate) {
        Animals animal = this.animalsRepository.getById(id);
        animal.setActive(!animal.getActive());

        if (animal.getActive() == false) {
            LocalDateTime now = LocalDateTime.now();
            Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
            animal.setAdoptionDate(date);

            animal.setAdoptionDate(adoptionDate);
        } else {
            animal.setAdoptionDate(null);
        }
        this.animalsRepository.save(animal);
    }
}
