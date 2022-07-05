package com.pasquali.vagas.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VagaStatus implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "STATUS_NOME", length = 64)
	private String statusNome;
	
	@Column(name = "ATIVO", length = 1)
	private int ativo;
	
	public VagaStatus() {
	}

	public VagaStatus(Integer id, String statusNome, int ativo) {
		super();
		this.id = id;
		this.statusNome = statusNome;
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "VagaStatus [id=" + id + ", statusNome=" + statusNome + ", ativo=" + ativo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusNome() {
		return statusNome;
	}

	public void setStatusNome(String statusNome) {
		this.statusNome = statusNome;
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
		VagaStatus other = (VagaStatus) obj;
		return Objects.equals(id, other.id);
	}
	
}
