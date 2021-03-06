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
public class VagaStatus implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "STATUS_NOME", length = 64)
	private String statusNome;
	
	@Column(name = "ATIVO", length = 1)
	private Integer ativo;
	
	@OneToMany(mappedBy="vagaStatus")
	private List<Vaga> vagas = new ArrayList<>();
	
	public VagaStatus() {
	}

	public VagaStatus(Integer id, String statusNome, Registro ativo) {
		super();
		this.id = id;
		this.statusNome = statusNome;
		this.ativo = ativo.getCod();
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
		VagaStatus other = (VagaStatus) obj;
		return Objects.equals(id, other.id);
	}
	
}
