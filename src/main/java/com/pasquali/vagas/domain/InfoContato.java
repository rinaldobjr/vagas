package com.pasquali.vagas.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InfoContato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME_APELIDO", length = 30)
	private String nomeApelido;
	
	@Column(name = "TELEFONE", length = 20)
	private String telefone;
	
	@Column(name = "EMAIL", length = 64)
	private String email;
	
	@Column(name = "WHATSAPP", length = 1)
	private int whatsapp;
	
	@Column(name = "ATIVO", length = 1)
	private int ativo;

	public InfoContato() {
	}

	public InfoContato(Integer id, String nomeApelido, String telefone, String email, int whatsapp, int ativo) {
		super();
		this.id = id;
		this.nomeApelido = nomeApelido;
		this.telefone = telefone;
		this.email = email;
		this.whatsapp = whatsapp;
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "InfoContato [id=" + id + ", nomeApelido=" + nomeApelido + ", telefone=" + telefone + ", email=" + email
				+ ", whatsapp=" + whatsapp + ", ativo=" + ativo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeApelido() {
		return nomeApelido;
	}

	public void setNomeApelido(String nomeApelido) {
		this.nomeApelido = nomeApelido;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		InfoContato other = (InfoContato) obj;
		return Objects.equals(id, other.id);
	}
	
}
