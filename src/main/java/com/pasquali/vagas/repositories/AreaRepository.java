package com.pasquali.vagas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasquali.vagas.domain.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer>{

}
