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
public class LocalTrabalho implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME_LOCAL", length = 36)
	private String nomeLocal;
	
	@Column(name = "ATIVO", length = 1)
	private Integer ativo;

	@OneToMany(mappedBy="localTrabalho")
	private List<Vaga> vagas = new ArrayList<>();
	
	public LocalTrabalho() {
	}

	public LocalTrabalho(Integer id, String nomeLocal, Registro ativo) {
		super();
		this.id = id;
		this.nomeLocal = nomeLocal;
		this.ativo = ativo.getCod();
	}

	@Override
	public String toString() {
		return "Local [id=" + id + ", nomeLocal=" + nomeLocal + ", ativo=" + ativo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeLocal() {
		return nomeLocal;
	}

	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}

	public Registro getAtivo() {
		return Registro.toEnum(ativo);
	}

	public void setAtivo(Registro ativo) {
		this.ativo = ativo.getCod();
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
		LocalTrabalho other = (LocalTrabalho) obj;
		return Objects.equals(id, other.id);
	}
	
}
