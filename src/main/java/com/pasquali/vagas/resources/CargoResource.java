package com.pasquali.vagas.resources;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pasquali.vagas.domain.Cargo;
import com.pasquali.vagas.services.CargoService;

@RestController
@RequestMapping(value="/cargos")
public class CargoResource {
	
	@Autowired
	private CargoService cargoService;
	
	private SessionFactory sessionFactory;
	
	//FindById
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Cargo objeto = cargoService.buscar(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	//ListAll
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Cargo>> listando() {
		List<Cargo> lista = cargoService.listar();
		//Statistics estatisticas = sessionFactory.getStatistics();
		//System.out.println(estatisticas.getQueryExecutionCount());
		return ResponseEntity.ok().body(lista);
	}
	
	
	/*
	 @RequestMapping(value="/listar", method=RequestMethod.GET)
	public List<Cargo> listar() {
		
		Cargo cg1 = new Cargo(1,"Analista",LocalDateTime.now(),null,1);
		Cargo cg2 = new Cargo(2,"Desenvolvedor",LocalDateTime.now(),null,1);
		
		List<Cargo> lista = new ArrayList<>();
		lista.add(cg1);
		lista.add(cg2);
		return lista;
	}
	 */

}
