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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LogEnvioEmail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_ENVIO")
	private Date dataEnvio;

	@Column(name = "QTDE_VAGAS", length = 3)
	private Integer qtdeVagas;

	// Relation
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public LogEnvioEmail() {}
	
	public LogEnvioEmail(Integer id, Date dataEnvio, Integer qtdeVagas, Usuario usuario) {
		super();
		this.id = id;
		this.dataEnvio = dataEnvio;
		this.qtdeVagas = qtdeVagas;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "LogEnvioEmail [id=" + id + ", dataEnvio=" + dataEnvio + ", qtdeVagas=" + qtdeVagas + ", usuario="
				+ usuario + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Integer getQtdeVagas() {
		return qtdeVagas;
	}

	public void setQtdeVagas(Integer qtdeVagas) {
		this.qtdeVagas = qtdeVagas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		LogEnvioEmail other = (LogEnvioEmail) obj;
		return Objects.equals(id, other.id);
	}

}
