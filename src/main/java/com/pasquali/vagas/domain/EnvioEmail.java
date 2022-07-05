package com.pasquali.vagas.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EnvioEmail implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME_COMPLETO", length = 120)
	private String nomeCompleto;
	
	@Column(name = "SEXO", length = 1)
	private String sexo;
	
	@Column(name = "EMAIL", length = 64)
	private String email;
	
	@Column(name = "TELEFONE", length = 20)
	private String telefone;
	
	@Column(name = "WHATSAPP", length = 1)
	private int whatsapp;
	
	@Column(name = "ATIVO", length = 1)
	private int ativo;
	
	public EnvioEmail() {
	}

	public EnvioEmail(Integer id, String nomeCompleto, String sexo, String email, String telefone, int whatsapp,
			int ativo) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefone;
		this.whatsapp = whatsapp;
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "EnvioEmail [id=" + id + ", nomeCompleto=" + nomeCompleto + ", sexo=" + sexo + ", email=" + email
				+ ", telefone=" + telefone + ", whatsapp=" + whatsapp + ", ativo=" + ativo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(int whatsapp) {
		this.whatsapp = whatsapp;
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
		EnvioEmail other = (EnvioEmail) obj;
		return Objects.equals(id, other.id);
	}
	
}
