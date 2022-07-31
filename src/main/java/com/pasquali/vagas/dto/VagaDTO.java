package com.pasquali.vagas.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pasquali.vagas.domain.Area;
import com.pasquali.vagas.domain.Cargo;
import com.pasquali.vagas.domain.Contrato;
import com.pasquali.vagas.domain.Empresa;
import com.pasquali.vagas.domain.InfoContato;
import com.pasquali.vagas.domain.LocalTrabalho;
import com.pasquali.vagas.domain.Nivel;
import com.pasquali.vagas.domain.Vaga;
import com.pasquali.vagas.domain.VagaStatus;

public class VagaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 10, max = 2048, message = "O tamanho deve ser entre 5 a 2048 caracteres")
	private String resumo;
	
	@Size(min = 10, max = 2048, message = "O tamanho deve ser entre 5 a 2048 caracteres")
	private String observacao;
	
	private Date criacao;
	
	private Date modificado;
	
	private Date encerrado;
	
	private Integer usuarioCriador;
	
	private Integer usuarioModificador;
	
	private Integer usuarioEncerrador;
	
	@NotNull
	private Cargo cargo;
	@NotNull
	private Nivel nivel;
	@NotNull
	private LocalTrabalho localTrabalho;
	@NotNull
	private Contrato contrato;
	@NotNull
	private InfoContato infoContato;
	@NotNull
	private Area area;
	@NotNull
	private VagaStatus vagaStatus;
	@NotNull
	private Empresa empresa;

	
	public VagaDTO() {
	}

	public VagaDTO(Vaga obj) {
		id = obj.getId();
		resumo = obj.getResumo();
		observacao = obj.getObservacao();
		criacao = obj.getCriacao();
		modificado = obj.getModificado();
		encerrado = obj.getEncerrado();
		usuarioCriador = obj.getUsuarioCriador();
		usuarioModificador = obj.getUsuarioModificador();
		usuarioEncerrador = obj.getUsuarioEncerrador();
		cargo = obj.getCargo();
		nivel = obj.getNivel();
		localTrabalho = obj.getLocalTrabalho();
		contrato = obj.getContrato();
		infoContato = obj.getInfoContato();
		area = obj.getArea();
		vagaStatus = obj.getVagaStatus();
		empresa = obj.getEmpresa();
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
	
}
