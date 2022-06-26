package com.pasquali.vagas.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/cargos")
public class CargoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "REST esta funcionando";
	}

}
