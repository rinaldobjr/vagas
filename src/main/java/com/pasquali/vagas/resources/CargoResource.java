package com.pasquali.vagas.resources;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pasquali.vagas.domain.Cargo;

@RestController
@RequestMapping(value="/cargos")
public class CargoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Cargo> listar() {
		
		Cargo cg1 = new Cargo(1L,"Analista",LocalDateTime.now(),null,1);
		Cargo cg2 = new Cargo(2L,"Desenvolvedor",LocalDateTime.now(),null,1);
		
		List<Cargo> lista = new ArrayList<>();
		lista.add(cg1);
		lista.add(cg2);
		return lista;
	}

}
