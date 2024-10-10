package com.br.project.v2.usecases.Animals.impl;

import com.br.project.v2.domain.entities.ImageAnimalModel;
import com.br.project.v2.usecases.Animals.UploadImageUseCase;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class UploadImageUseCaseImpl implements UploadImageUseCase {

    @Override
    public Set<ImageAnimalModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageAnimalModel> imageModels = new HashSet<>();

        for(MultipartFile file: multipartFiles) {
            ImageAnimalModel imageModel = new ImageAnimalModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes());
            imageModels.add(imageModel);
        }
        return imageModels;
    }
}
