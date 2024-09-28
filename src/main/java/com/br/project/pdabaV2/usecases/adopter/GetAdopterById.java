package com.br.project.pdabaV2.usecases.adopter;

import com.br.project.pdabaV2.adapters.dtos.AdopterDTO;

public interface GetAdopterById {

    AdopterDTO getAdopterById(Long id);
}
