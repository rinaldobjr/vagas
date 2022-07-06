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
public class Cargo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME_CARGO", length = 100)
	private String nomeCargo;
	
	@Column(name = "ATIVO", length = 1)
	private int ativo;
	
	@OneToMany(mappedBy="cargo")
	private List<Vaga> vagas = new ArrayList<>();
	
	public Cargo() {
	}

	public Cargo(Integer id, String nomeCargo, int ativo) {
		super();
		this.id = id;
		this.nomeCargo = nomeCargo;
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nomeCargo=" + nomeCargo + ", ativo=" + ativo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
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

//@Column(name = "CREATED")
//private LocalDateTime criacao;
//
//@Column(name = "MODIFIED")
//private LocalDateTime modificado;