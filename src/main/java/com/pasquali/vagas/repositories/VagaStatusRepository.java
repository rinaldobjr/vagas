package com.pasquali.vagas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasquali.vagas.domain.VagaStatus;

@Repository
public interface VagaStatusRepository extends JpaRepository<VagaStatus, Integer>{

}
