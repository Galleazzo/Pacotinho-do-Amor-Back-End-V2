package com.br.project.v2.usecases.Animals;

import com.br.project.v2.domain.entities.ImageAnimalModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

public interface UploadImageUseCase {

    Set<ImageAnimalModel> uploadImage(MultipartFile[] multipartFiles) throws IOException;
}
