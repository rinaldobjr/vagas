package com.pasquali.vagas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pasquali.vagas.domain.Area;
import com.pasquali.vagas.domain.enums.Registro;

public class AreaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 5, max = 50, message = "O tamanho deve ser entre 5 a 50 caracteres")
	private String nomeArea;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 2, max = 7, message = "O tamanho deve ser entre 2 a 7 caracteres")
	private String nome;

	@NotNull
	private Registro ativo;

	public AreaDTO() {
	}

	public AreaDTO(Area obj) {
		id = obj.getId();
		nome = obj.getNome();
		nomeArea = obj.getNomeArea();
		ativo = obj.getAtivo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeArea() {
		return nomeArea;
	}

	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
