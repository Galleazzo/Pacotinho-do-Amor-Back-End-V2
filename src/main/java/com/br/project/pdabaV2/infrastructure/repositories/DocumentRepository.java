package com.br.project.pdabaV2.infrastructure.repositories;

import br.com.backEnd.pacotinho.core.domain.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
