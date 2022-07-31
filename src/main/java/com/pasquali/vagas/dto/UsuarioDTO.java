package com.pasquali.vagas.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pasquali.vagas.domain.Estado;
import com.pasquali.vagas.domain.Usuario;
import com.pasquali.vagas.domain.enums.Permissao;
import com.pasquali.vagas.domain.enums.Registro;
import com.pasquali.vagas.domain.enums.Sexo;
import com.pasquali.vagas.domain.enums.TipoUsuario;

public class UsuarioDTO {

	private Integer id;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 7, max = 90, message = "O tamanho deve ser entre 7 a 90 caracteres")
	private String login;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 7, max = 150, message = "O tamanho deve ser entre 7 a 150 caracteres")
	private String senha;

	@NotNull
	private TipoUsuario tipoUsuario;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 7, max = 150, message = "O tamanho deve ser entre 7 a 150 caracteres")
	private String nomeCompleto;

	private String nomeApelido;

	private String telefone;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 11, max = 20)
	private String celular;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 11, max = 120)
	private String email;

	@NotNull
	private Permissao enviaEmail;

	@NotNull
	private Permissao whatsapp;

	@NotNull
	private Sexo sexo;

	@NotNull
	private Registro ativo;
	
	@NotNull
	private Estado estado;
	
	public UsuarioDTO() { }
	
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		login = obj.getLogin();
		senha = obj.getSenha();
		tipoUsuario = obj.getTipoUsuario();
		nomeCompleto = obj.getNomeCompleto();
		nomeApelido = obj.getNomeApelido();
		telefone = obj.getTelefone();
		celular = obj.getCelular();
		email = obj.getEmail();
		enviaEmail = obj.getEnviaEmail();
		whatsapp = obj.getWhatsapp();
		sexo = obj.getSexo();
		ativo = obj.getAtivo();
		estado = obj.getEstado();
	}
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Integer tipoUsuario) {
		if (tipoUsuario == 1) {
			this.tipoUsuario = TipoUsuario.USUARIO;
		} else if (tipoUsuario == 2) {
			this.tipoUsuario = TipoUsuario.EDITOR;
		} else if (tipoUsuario == 3) {
			this.tipoUsuario = TipoUsuario.GESTOR;
		} else if (tipoUsuario == 4) {
			this.tipoUsuario = TipoUsuario.ADMIN;
		} else {
			this.tipoUsuario = TipoUsuario.USUARIO;
		}
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public Permissao getEnviaEmail() {
		return enviaEmail;
	}

	public void setEnviaEmail(Integer enviaEmail) {
		//this.enviaEmail = enviaEmail;
		if (enviaEmail == 1) {
			this.whatsapp = Permissao.SIM;
		} else {
			this.whatsapp = Permissao.NAO;
		}
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		if (sexo == 1) {
			this.sexo = Sexo.MASCULINO;
		} else {
			this.sexo = Sexo.FEMININO;
		}
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
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
