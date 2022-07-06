package com.pasquali.vagas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasquali.vagas.domain.LocalTrabalho;

@Repository
public interface LocalTrabalhoRepository extends JpaRepository<LocalTrabalho, Integer>{

}
