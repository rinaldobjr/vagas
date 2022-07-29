package com.pasquali.vagas.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasquali.vagas.domain.LogAcao;

@Repository
public interface LogAcaoRepository extends JpaRepository<LogAcao, Integer>{

	Page<LogAcao> findByTipoAcaoOrderByDataDesc(Integer tipoAcao, PageRequest pages);

	Page<LogAcao> findByTabelaOrderByDataDescHoraDesc(String tabela, PageRequest pages);

	Page<LogAcao> findByUsuarioOrderByDataDesc(Integer usuario, PageRequest pages);

}
