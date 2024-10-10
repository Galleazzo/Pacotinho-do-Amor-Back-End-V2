package com.br.project.v2.usecases.adopter.impl;

import com.br.project.v2.infrastructure.repositories.AdopterRepository;
import com.br.project.v2.usecases.adopter.DeleteAdopterUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteAdopterUseCaseImpl implements DeleteAdopterUseCase {

    @Autowired
    private AdopterRepository adopterRepository;

    @Override
    @Transactional
    public void deleteAdopter(Long id) {
        try {
            this.adopterRepository.deleteById(id);
        }catch (Exception e) {
            throw new RuntimeException("Não foi possivel fazer a exclusao!");
        }
    }
}
