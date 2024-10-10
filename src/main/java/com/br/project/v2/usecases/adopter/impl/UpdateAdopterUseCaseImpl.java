package com.br.project.v2.usecases.adopter.impl;

import com.br.project.v2.adapters.dtos.AdopterDTO;
import com.br.project.v2.domain.entities.Adopter;
import com.br.project.v2.infrastructure.repositories.AdopterRepository;
import com.br.project.v2.infrastructure.repositories.AnimalsRepository;
import com.br.project.v2.usecases.adopter.UpdateAdopterUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateAdopterUseCaseImpl implements UpdateAdopterUseCase {

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private AnimalsRepository animalsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public AdopterDTO updateAdopter(Long id, AdopterDTO updatedAdopterDTO) {
        Optional<Adopter> optionalAdopter = adopterRepository.findById(id);
        if (optionalAdopter.isPresent()) {
            Adopter existingAdopter = optionalAdopter.get();
            modelMapper.map(updatedAdopterDTO, existingAdopter);
            existingAdopter.setId(id);
            Adopter savedAdopter = adopterRepository.save(existingAdopter);
            return modelMapper.map(savedAdopter, AdopterDTO.class);
        } else {
            throw new RuntimeException("Adopter not found with id " + id);
        }
    }
}
