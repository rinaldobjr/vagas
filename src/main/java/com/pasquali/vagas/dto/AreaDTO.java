package com.pasquali.vagas.dto;

import java.io.Serializable;

import com.pasquali.vagas.domain.Area;

public class AreaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nomeArea;
	private String nome;
	private Integer ativo;


	public AreaDTO() { }

	public AreaDTO(Area obj) { 
		id = obj.getId();
		nome = obj.getNome();
		nomeArea = obj.getNomeArea();
		ativo = obj.getAtivo().getCod();
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


	public Integer getAtivo() {
		return ativo;
	}


	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	
	
}
