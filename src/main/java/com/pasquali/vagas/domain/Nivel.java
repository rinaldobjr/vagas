package com.pasquali.vagas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Nivel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME_NIVEL", length = 20)
	private String nomeNivel;
	
	@Column(name = "ATIVO", length = 1)
	private int ativo;
	
	@OneToMany(mappedBy="nivel")
	private List<Vaga> vagas = new ArrayList<>();
	
	public Nivel() {
	}

	public Nivel(Integer id, String nomeNivel, int ativo) {
		super();
		this.id = id;
		this.nomeNivel = nomeNivel;
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Nivel [id=" + id + ", nomeNivel=" + nomeNivel + ", ativo=" + ativo + "]";
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
		Nivel other = (Nivel) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
