package com.pasquali.vagas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pasquali.vagas.domain.Nivel;
import com.pasquali.vagas.domain.enums.Registro;

public class NivelDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 5, max = 20, message = "O tamanho deve ser entre 5 a 20 caracteres")
	private String nomeNivel;
	
	@NotNull
	private Registro ativo;
	
	public NivelDTO() { }
	
	public NivelDTO(Nivel obj) { 
		id = obj.getId();
		nomeNivel = obj.getNomeNivel();
		ativo = obj.getAtivo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeNivel() {
		return nomeNivel;
	}

	public void setNomeNivel(String nomeNivel) {
		this.nomeNivel = nomeNivel;
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
