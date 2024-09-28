package com.br.project.pdabaV2.adapters.controllers.impl;

import br.com.backEnd.pacotinho.adapters.web.controllers.AnimalsController;
import br.com.backEnd.pacotinho.adapters.web.dtos.AnimalsDTO;
import br.com.backEnd.pacotinho.core.domain.entities.ImageAnimalModel;
import br.com.backEnd.pacotinho.core.usecases.Animals.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController(value = "APIs to get, post, put and delete animals")
@RequestMapping("/animals")
public class AnimalsControllerImpl implements AnimalsController {

    @Autowired
    private ChangeActiveUseCase changeActiveUseCase;

    @Autowired
    private DeleteAnimalUseCase deleteAnimalUseCase;

    @Autowired
    private GetByCriteriaUseCase getByCriteriaUseCase;

    @Autowired
    private GetByIdUseCase getById;

    @Autowired
    private SaveUseCase saveUseCase;

    @Autowired
    private UploadImageUseCase uploadImageUseCase;

    @Override
    @GetMapping
    public ResponseEntity<AnimalsDTO> getById(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(this.getById.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<AnimalsDTO> save(@RequestPart("animal") AnimalsDTO animalsDTO, @RequestPart(value = "imageFile", required = false) MultipartFile[] file) throws Exception {
        Set<ImageAnimalModel> images = new HashSet<>();

        if (file != null && file.length > 0) {
            images = this.uploadImageUseCase.uploadImage(file);
        }

        animalsDTO.setAnimalImage(images);
        return new ResponseEntity<>(this.saveUseCase.save(animalsDTO), HttpStatus.CREATED);
    }

    @Override
    @GetMapping(path = "/getByCriteria")
    public ResponseEntity<Page<AnimalsDTO>> getByCriteria(@RequestParam String name, @RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam String sort, @RequestParam String order){
        return new ResponseEntity<>(this.getByCriteriaUseCase.getByCriteria(name, page, pageSize, sort, order), HttpStatus.OK);
    }

    @Override
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestParam Long id) throws Exception {
        this.deleteAnimalUseCase.deleteAnimal(id);
    }


    @Override
    @PostMapping(path = "/changeActive")
    public void changeActive(@RequestParam Long id, @RequestParam() Date adoptionDate) {
        this.changeActiveUseCase.changeActive(id, adoptionDate);
    }

}
