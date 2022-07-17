package com.pasquali.vagas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pasquali.vagas.domain.Cidade;
import com.pasquali.vagas.domain.enums.Registro;

public class CidadeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotNull(message = "Preenchimento obrigatorio")
	@Size(min = 5, max = 80, message = "O tamanho deve ser entre 5 a 45 caracteres")
	private String nome;
	
	@NotNull
	private Integer estado;
	
	@NotNull
	private Registro ativo;
	
	public CidadeDTO() {
	}
	
	public CidadeDTO(Cidade obj) {
		id = obj.getId();
		nome = obj.getNome();
		ativo = obj.getAtivo();
		estado = obj.getEstado().getId();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
	
}
