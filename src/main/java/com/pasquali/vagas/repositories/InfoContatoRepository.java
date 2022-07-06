package com.pasquali.vagas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasquali.vagas.domain.InfoContato;

@Repository
public interface InfoContatoRepository extends JpaRepository<InfoContato, Integer>{

}
