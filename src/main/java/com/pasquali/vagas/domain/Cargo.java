package com.pasquali.vagas.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Cargo implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nomeCargo;
	
	private LocalDateTime criacao;
	
	private LocalDateTime modificado;
	
	private int ativo;
	
	public Cargo() {
	}

	public Cargo(Long id, String nomeCargo, LocalDateTime criacao, LocalDateTime modificado, int ativo) {
		super();
		this.id = id;
		this.nomeCargo = nomeCargo;
		this.criacao = criacao;
		this.modificado = modificado;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public LocalDateTime getCriacao() {
		return criacao;
	}

	public void setCriacao(LocalDateTime criacao) {
		this.criacao = criacao;
	}

	public LocalDateTime getModificado() {
		return modificado;
	}

	public void setModificado(LocalDateTime modificado) {
		this.modificado = modificado;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
