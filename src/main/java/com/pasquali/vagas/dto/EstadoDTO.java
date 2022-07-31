package com.pasquali.vagas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pasquali.vagas.domain.Estado;
import com.pasquali.vagas.domain.enums.Registro;

public class EstadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotNull(message = "Preenchimento obrigatorio")
	@Size(min = 5, max = 40, message = "O tamanho deve ser entre 5 a 40 caracteres")
	private String nome;
	
	@NotNull(message = "Preenchimento obrigatorio")
	private String sigla;
	
	@NotNull
	private Registro ativo;
	
	
	public EstadoDTO() { }
	
	public EstadoDTO(Estado obj) {
		id = obj.getId();
		nome = obj.getNome();
		sigla = obj.getSigla();
		ativo = obj.getAtivo();
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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
