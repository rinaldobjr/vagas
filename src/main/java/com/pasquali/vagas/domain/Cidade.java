package com.pasquali.vagas.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME", length = 45)
	private String nome;
	
	@Column(name = "ATIVO", length = 1)
	private int ativo;
	
	//Relacionamento
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;
	
	public Cidade() {
	}

	public Cidade(Integer id, String nome, int ativo, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.ativo = ativo;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", ativo=" + ativo + ", estado=" + estado + "]";
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
		Cidade other = (Cidade) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
