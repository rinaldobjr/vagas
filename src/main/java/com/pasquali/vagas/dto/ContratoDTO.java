package com.pasquali.vagas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pasquali.vagas.domain.Contrato;
import com.pasquali.vagas.domain.enums.Registro;

public class ContratoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 5, max = 30, message = "O tamanho deve ser entre 5 a 50 caracteres")
	private String nomeContrato;
	
	@NotNull
	private Registro ativo;
	
	public ContratoDTO() { }

	public ContratoDTO(Contrato obj) {
		super();
		this.id = obj.getId();
		this.nomeContrato = obj.getNomeContrato();
		this.ativo = obj.getAtivo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeContrato() {
		return nomeContrato;
	}

	public void setNomeContrato(String nomeContrato) {
		this.nomeContrato = nomeContrato;
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
