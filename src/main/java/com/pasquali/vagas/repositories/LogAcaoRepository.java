package com.pasquali.vagas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasquali.vagas.domain.LogAcao;

@Repository
public interface LogAcaoRepository extends JpaRepository<LogAcao, Integer>{

}
