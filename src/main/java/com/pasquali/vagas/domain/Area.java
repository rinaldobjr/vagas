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

import com.pasquali.vagas.domain.enums.Registro;

@Entity
public class Area implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME_AREA", length = 50)
	private String nomeArea;
	
	@Column(name = "NOME", length = 7)
	private String nome;
	
	@Column(name = "ATIVO", length = 1)
	private Integer ativo;

	@OneToMany(mappedBy="area")
	private List<Vaga> vagas = new ArrayList<>();
	
	public Area() {
	}

	public Area(Integer id, String nomeArea, String nome, Registro ativo) {
		super();
		this.id = id;
		this.nomeArea = nomeArea;
		this.nome = nome;
		this.ativo = ativo.getCod();
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", nomeArea=" + nomeArea + ", nome=" + nome + ", ativo=" + ativo + "]";
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

	public Registro getAtivo() {
		return Registro.toEnum(ativo);
	}

	public void setAtivo(Registro ativo) {
		this.ativo = ativo.getCod();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Area other = (Area) obj;
		return Objects.equals(id, other.id);
	}
	
}
