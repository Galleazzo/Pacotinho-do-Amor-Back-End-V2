package com.br.project.v2.usecases.adopter;

import com.br.project.v2.adapters.dtos.AdopterDTO;

public interface GetAdopterById {

    AdopterDTO getAdopterById(Long id);
}
