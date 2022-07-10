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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.pasquali.vagas.domain.enums.Permissao;
import com.pasquali.vagas.domain.enums.Registro;
import com.pasquali.vagas.domain.enums.Sexo;
import com.pasquali.vagas.domain.enums.TipoUsuario;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "LOGIN", length = 90)
	private String login;

	@Column(name = "SENHA", length = 150)
	private String senha;

	@Column(name = "TIPO_USUARIO", length = 1)
	private Integer tipoUsuario;

	@Column(name = "NOME_COMPLETO", length = 100)
	private String nomeCompleto;

	@Column(name = "NOME_APELIDO", length = 36)
	private String nomeApelido;

	@Column(name = "TELEFONE", length = 20)
	private String telefone;

	@Column(name = "CELULAR", length = 20)
	private String celular;

	@Column(name = "EMAIL", length = 120)
	private String email;

	@Column(name = "ENVIA_EMAIL", length = 1)
	private Integer enviaEmail;

	@Column(name = "WHATSAPP", length = 1)
	private Integer whatsapp;

	@Column(name = "SEXO", length = 1)
	private Integer sexo;

	@Column(name = "ATIVO", length = 1)
	private Integer ativo;

	public Usuario() {}
	
	// Relation
	//@JsonManagedReference
	@OneToMany(mappedBy = "usuario")
	private List<LogAcao> logsAcao = new ArrayList<>();

	// Relation

	@OneToMany(mappedBy = "usuario")
	private List<LogEnvioEmail> logsEnvioEmail = new ArrayList<>();

	// Relation
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;


	public Usuario(Integer id, String login, String senha, TipoUsuario tipoUsuario, String nomeCompleto,
			String nomeApelido, String telefone, String celular, String email, Integer enviaEmail, Permissao whatsapp,
			Sexo sexo, Registro ativo, Estado estado,List<LogAcao> logsAcao, List<LogEnvioEmail> logsEnvioEmail) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario.getCod();
		this.nomeCompleto = nomeCompleto;
		this.nomeApelido = nomeApelido;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.enviaEmail = enviaEmail;
		this.whatsapp = whatsapp.getCod();
		this.sexo = sexo.getCod();
		this.ativo = ativo.getCod();
		this.estado = estado;
		this.logsAcao = logsAcao;
		this.logsEnvioEmail = logsEnvioEmail;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", tipoUsuario=" + tipoUsuario
				+ ", nomeCompleto=" + nomeCompleto + ", nomeApelido=" + nomeApelido + ", telefone=" + telefone
				+ ", celular=" + celular + ", email=" + email + ", enviaEmail=" + enviaEmail + ", whatsapp=" + whatsapp
				+ ", sexo=" + sexo + ", ativo=" + ativo + ", estado=" + estado + "]";
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
		return TipoUsuario.toEnum(tipoUsuario);
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario.getCod();
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

	public Integer getEnviaEmail() {
		return enviaEmail;
	}

	public void setEnviaEmail(Integer enviaEmail) {
		this.enviaEmail = enviaEmail;
	}

	public Permissao getWhatsapp() {
		return Permissao.toEnum(whatsapp);
	}

	public void setWhatsapp(Permissao whatsapp) {
		this.whatsapp = whatsapp.getCod();
	}

	public Sexo getSexo() {
		return Sexo.toEnum(sexo);
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo.getCod();
	}

	public Registro getAtivo() {
		return Registro.toEnum(ativo);
	}

	public void setAtivo(Registro ativo) {
		this.ativo = ativo.getCod();
	}

	public List<LogAcao> getLogsAcao() {
		return logsAcao;
	}

	public void setLogsAcao(List<LogAcao> logsAcao) {
		this.logsAcao = logsAcao;
	}

	public List<LogEnvioEmail> getLogsEnvioEmail() {
		return logsEnvioEmail;
	}

	public void setLogsEnvioEmail(List<LogEnvioEmail> logsEnvioEmail) {
		this.logsEnvioEmail = logsEnvioEmail;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, login, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(login, other.login) && Objects.equals(senha, other.senha);
	}

}
