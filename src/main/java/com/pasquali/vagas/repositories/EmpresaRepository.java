package com.pasquali.vagas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasquali.vagas.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

}
