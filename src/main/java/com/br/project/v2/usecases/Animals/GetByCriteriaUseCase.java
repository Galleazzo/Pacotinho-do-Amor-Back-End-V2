package com.br.project.v2.usecases.Animals;


import com.br.project.v2.adapters.dtos.AnimalsDTO;
import org.springframework.data.domain.Page;

public interface GetByCriteriaUseCase {

    Page<AnimalsDTO> getByCriteria(String name, Integer page, Integer pageSize, String sort, String order);
}
