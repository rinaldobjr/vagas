package com.pasquali.vagas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasquali.vagas.domain.LogEnvioEmail;

@Repository
public interface LogEnvioEmailRepository extends JpaRepository<LogEnvioEmail, Integer>{

}
