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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pasquali.vagas.domain.enums.Permissao;
import com.pasquali.vagas.domain.enums.Registro;

@Entity
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME_EMPRESA", length = 100)
	private String nomeEmpresa;
	
	@Column(name = "ENDERECO", length = 100)
	private String endereco;
	
	@Column(name = "NUMERO", length = 6)
	private String numero;
	
	@Column(name = "COMPLEMENTO", length = 35)
	private String complemento;
	
	@Column(name = "BAIRRO", length = 30)
	private String bairro;
	
	@Column(name = "CEP", length = 9)
	private String cep;
	
	@Column(name = "WHATSAPP", length = 1)
	private Integer whatsapp;
	
	@Column(name = "TELEFONE", length = 20)
	private String telefone;
	
	@Column(name = "CELULAR", length = 20)
	private String celular;
	
	@Column(name = "EMAIL", length = 64)
	private String email;
	
	@Column(name = "ATIVO", length = 1)
	private Integer ativo;
	
	//Relation
	@JsonManagedReference
	@OneToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	
	//Relation
	@JsonBackReference
	@OneToMany(mappedBy="empresa")
	private List<Vaga> vagas = new ArrayList<>();
	
	public Empresa() {
	}

	public Empresa(Integer id, String nomeEmpresa, String endereco, String numero, String complemento, String bairro,
			String cep, Permissao whatsapp, String telefone, String celular, String email, Registro ativo, Cidade cidade) {
		super();
		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.whatsapp = whatsapp.getCod();
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.ativo = ativo.getCod();
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nomeEmpresa=" + nomeEmpresa + ", endereco=" + endereco + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep + ", whatsapp=" + whatsapp
				+ ", telefone=" + telefone + ", celular=" + celular + ", email=" + email + ", ativo=" + ativo
				+ ", cidade=" + cidade + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Permissao getWhatsapp() {
		return Permissao.toEnum(whatsapp);
	}

	public void setWhatsapp(Permissao whatsapp) {
		this.whatsapp = whatsapp.getCod();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		Empresa other = (Empresa) obj;
		return Objects.equals(id, other.id);
	}

}
