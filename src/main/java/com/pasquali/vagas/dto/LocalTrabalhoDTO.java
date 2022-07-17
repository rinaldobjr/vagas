package com.pasquali.vagas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pasquali.vagas.domain.LocalTrabalho;
import com.pasquali.vagas.domain.enums.Registro;

public class LocalTrabalhoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 5, max = 100, message = "O tamanho deve ser entre 5 a 100 caracteres")
	private String nomeLocal;
	
	@NotNull
	private Registro ativo;
	
	public LocalTrabalhoDTO() { }
	
	public LocalTrabalhoDTO(LocalTrabalho obj) { 
		id = obj.getId();
		nomeLocal = obj.getNomeLocal();
		ativo = obj.getAtivo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeLocal() {
		return nomeLocal;
	}

	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
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
