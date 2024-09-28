package com.br.project.pdabaV2.infrastructure.repositories;

import br.com.backEnd.pacotinho.core.domain.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
