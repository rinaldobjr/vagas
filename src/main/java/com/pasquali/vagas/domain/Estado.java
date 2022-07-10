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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pasquali.vagas.domain.enums.Registro;

@Entity
public class Estado implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME", length = 40)
	private String nome;
	
	@Column(name = "ATIVO", length = 1)
	private Integer ativo;
	
	//Relation
	@JsonBackReference
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidades = new ArrayList<>();
	
	//Relation
	@JsonBackReference
	@OneToMany(mappedBy="estado")
	private List<Usuario> usuarios = new ArrayList<>();
	
	public Estado() {}

	public Estado(Integer id, String nome, Registro ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.ativo = ativo.getCod();
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", ativo=" + ativo + "]";
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
		return Registro.toEnum(ativo);
	}

	public void setAtivo(Registro ativo) {
		this.ativo = ativo.getCod();
	}
	
	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
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
		Estado other = (Estado) obj;
		return Objects.equals(id, other.id);
	}
	
}
