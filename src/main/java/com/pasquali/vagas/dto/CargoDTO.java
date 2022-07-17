package com.pasquali.vagas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pasquali.vagas.domain.Cargo;
import com.pasquali.vagas.domain.enums.Registro;

public class CargoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 5, max = 100, message = "O tamanho deve ser entre 5 a 100 caracteres")
	private String nomeCargo;
	
	@NotNull
	private Registro ativo;
	
	public CargoDTO() { }
	
	public CargoDTO(Cargo obj) { 
		id = obj.getId();
		nomeCargo = obj.getNomeCargo();
		ativo = obj.getAtivo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public Registro getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		if (ativo == 1) {
			this.ativo = Registro.ATIVO;
		} else {
			this.ativo = Registro.INATIVO;
		}
	}
	
	
}
