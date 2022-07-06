package com.pasquali.vagas.domain;

import java.io.Serializable;
import java.util.Date;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	//Status => Ativo ou Desativado
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CLOSED")
	private Date encerrado;
	
	@Column(name = "USER_CREATED")
	private Integer usuarioCriador;
	
	@Column(name = "USER_MODIFIED")
	private Integer usuarioModificador;
	
	@Column(name = "USER_CLOSED")
	private Integer usuarioEncerrador;
	
	//Relation
	@ManyToOne
	@JoinColumn(name = "CARGO_ID")
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name = "NIVEL_ID")
	private Nivel nivel;
	
	@ManyToOne
	@JoinColumn(name = "LOCAL_TRABALHO_ID")
	private LocalTrabalho localTrabalho;
	
	@ManyToOne
	@JoinColumn(name = "CONTRATO_ID")
	private Contrato contrato;
	
	@ManyToOne
	@JoinColumn(name = "INFO_CONTATO_ID")
	private InfoContato infoContato;
	
	@ManyToOne
	@JoinColumn(name = "AREA_ID")
	private Area area;
	
	@ManyToOne
	@JoinColumn(name = "VAGA_STATUS_ID")
	private VagaStatus vagaStatus;
	
	@ManyToOne
	@JoinColumn(name = "EMPRESA_ID")
	private Empresa empresa;
	
	
	
	public Vaga() {
	}

	
	
	
}
