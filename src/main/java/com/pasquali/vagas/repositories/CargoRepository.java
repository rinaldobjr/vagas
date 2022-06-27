package com.pasquali.vagas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasquali.vagas.domain.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer>{

}
