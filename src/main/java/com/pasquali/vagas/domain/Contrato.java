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
public class Contrato implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME_CONTRATO", length = 30)
	private String nomeContrato;
	
	@Column(name = "ATIVO", length = 1)
	private Integer ativo;

	@OneToMany(mappedBy="contrato")
	private List<Vaga> vagas = new ArrayList<>();
	
	public Contrato() {
	}

	public Contrato(Integer id, String nomeContrato, Registro ativo) {
		super();
		this.id = id;
		this.nomeContrato = nomeContrato;
		this.ativo = (ativo == null)?1:ativo.getCod();
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", nomeContrato=" + nomeContrato + ", ativo=" + ativo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeContrato() {
		return nomeContrato;
	}

	public void setNomeContrato(String nomeContrato) {
		this.nomeContrato = nomeContrato;
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
		Contrato other = (Contrato) obj;
		return Objects.equals(id, other.id);
	}
	
}
