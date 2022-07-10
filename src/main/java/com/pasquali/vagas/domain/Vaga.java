package com.pasquali.vagas.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vaga implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "RESUMO", length = 2048)
	private String resumo;

	@Column(name = "OBSERVACAO", length = 2048)
	private String observacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED")
	private Date criacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED")
	private Date modificado;

	// Status => Ativo ou Desativado
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CLOSED")
	private Date encerrado;

	@Column(name = "USER_CREATED")
	private Integer usuarioCriador;

	@Column(name = "USER_MODIFIED")
	private Integer usuarioModificador;

	@Column(name = "USER_CLOSED")
	private Integer usuarioEncerrador;

	// Relation
	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;

	// Relation
	@ManyToOne
	@JoinColumn(name = "nivel_id")
	private Nivel nivel;

	// Relation
	@ManyToOne
	@JoinColumn(name = "local_trabalho_id")
	private LocalTrabalho localTrabalho;

	// Relation
	@ManyToOne
	@JoinColumn(name = "contrato_id")
	private Contrato contrato;

	// Relation
	@ManyToOne
	@JoinColumn(name = "info_contato_id")
	private InfoContato infoContato;

	// Relation
	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;

	// Relation
	@ManyToOne
	@JoinColumn(name = "vaga_status_id")
	private VagaStatus vagaStatus;

	// Relation
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	public Vaga() {
	}

	public Vaga(Integer id, String resumo, String observacao, Date criacao, Date modificado, Date encerrado,
			Integer usuarioCriador, Integer usuarioModificador, Integer usuarioEncerrador, Cargo cargo, Nivel nivel,
			LocalTrabalho localTrabalho, Contrato contrato, InfoContato infoContato, Area area, VagaStatus vagaStatus,
			Empresa empresa) {
		super();
		this.id = id;
		this.resumo = resumo;
		this.observacao = observacao;
		this.criacao = criacao;
		this.modificado = modificado;
		this.encerrado = encerrado;
		this.usuarioCriador = usuarioCriador;
		this.usuarioModificador = usuarioModificador;
		this.usuarioEncerrador = usuarioEncerrador;
		this.cargo = cargo;
		this.nivel = nivel;
		this.localTrabalho = localTrabalho;
		this.contrato = contrato;
		this.infoContato = infoContato;
		this.area = area;
		this.vagaStatus = vagaStatus;
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Vaga [id=" + id + ", resumo=" + resumo + ", observacao=" + observacao + ", criacao=" + criacao
				+ ", modificado=" + modificado + ", encerrado=" + encerrado + ", usuarioCriador=" + usuarioCriador
				+ ", usuarioModificador=" + usuarioModificador + ", usuarioEncerrador=" + usuarioEncerrador + ", cargo="
				+ cargo + ", nivel=" + nivel + ", localTrabalho=" + localTrabalho + ", contrato=" + contrato
				+ ", infoContato=" + infoContato + ", area=" + area + ", vagaStatus=" + vagaStatus + ", empresa="
				+ empresa + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public Date getModificado() {
		return modificado;
	}

	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}

	public Date getEncerrado() {
		return encerrado;
	}

	public void setEncerrado(Date encerrado) {
		this.encerrado = encerrado;
	}

	public Integer getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(Integer usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public Integer getUsuarioModificador() {
		return usuarioModificador;
	}

	public void setUsuarioModificador(Integer usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	public Integer getUsuarioEncerrador() {
		return usuarioEncerrador;
	}

	public void setUsuarioEncerrador(Integer usuarioEncerrador) {
		this.usuarioEncerrador = usuarioEncerrador;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public LocalTrabalho getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(LocalTrabalho localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public InfoContato getInfoContato() {
		return infoContato;
	}

	public void setInfoContato(InfoContato infoContato) {
		this.infoContato = infoContato;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public VagaStatus getVagaStatus() {
		return vagaStatus;
	}

	public void setVagaStatus(VagaStatus vagaStatus) {
		this.vagaStatus = vagaStatus;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
		Vaga other = (Vaga) obj;
		return Objects.equals(id, other.id);
	}

}
