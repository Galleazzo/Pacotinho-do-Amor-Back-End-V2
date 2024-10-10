package com.br.project.v2.adapters.controllers;

import com.br.project.v2.adapters.dtos.AdopterDTO;
import org.springframework.http.ResponseEntity;

public interface AdopterController {


    ResponseEntity<AdopterDTO> createAdopter(AdopterDTO adopterDTO);

    ResponseEntity<AdopterDTO> updateAdopter(Long id, AdopterDTO adopterDTO);

    ResponseEntity<Void> deleteAdopter(Long id);

    ResponseEntity<AdopterDTO> getAdopterById(Long id);

    ResponseEntity<AdopterDTO> adoptAnimal(Long adopterId, Long animalId);

}
