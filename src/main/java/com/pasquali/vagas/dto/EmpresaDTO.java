package com.pasquali.vagas.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pasquali.vagas.domain.Empresa;
import com.pasquali.vagas.domain.enums.Permissao;
import com.pasquali.vagas.domain.enums.Registro;

public class EmpresaDTO {

	private Integer id;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 5, max = 100, message = "O tamanho deve ser entre 5 a 100 caracteres")
	private String nomeEmpresa;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 5, max = 100, message = "O tamanho deve ser entre 5 a 100 caracteres")
	private String endereco;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 1, max = 6, message = "O tamanho deve ser entre 1 a 6 caracteres")
	private String numero;
	
	private String complemento;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 1, max = 30, message = "O tamanho deve ser entre 1 a 30 caracteres")
	private String bairro;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 5, max = 9, message = "O tamanho deve ser entre 5 a 9 caracteres")
	private String cep;
	
	@NotNull
	private Permissao whatsapp;
	
	@Size(min = 5, max = 15, message = "O tamanho deve ser entre 5 a 11 caracteres")
	private String telefone;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 5, max = 15, message = "O tamanho deve ser entre 5 a 11 caracteres")
	private String celular;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Email
	private String email;
	
	@NotNull
	private Registro ativo;
	
	@NotNull
	private Integer cidade;
	

	public EmpresaDTO() {}
	
	public EmpresaDTO(Empresa obj) {
		id = obj.getId();
		nomeEmpresa = obj.getNomeEmpresa();
		endereco = obj.getEndereco();
		numero = obj.getNumero();
		complemento = obj.getComplemento();
		bairro = obj.getBairro();
		cep = obj.getCep();
		whatsapp = obj.getWhatsapp();
		telefone = obj.getTelefone();
		celular = obj.getCelular();
		email = obj.getEmail();
		ativo = obj.getAtivo();
		cidade = obj.getCidade().getId();
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
		return whatsapp;
	}
	
	public void setWhatsapp(Integer whatsapp) {
		if (whatsapp == 1) {
			this.whatsapp = Permissao.SIM;
		} else {
			this.whatsapp = Permissao.NAO;
		}
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

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	
	public Registro getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		if (ativo == 1) {
			this.ativo = Registro.ATIVO;
		} else {
			this.ativo = Registro.INATIVO;
		}
	}
	
}
