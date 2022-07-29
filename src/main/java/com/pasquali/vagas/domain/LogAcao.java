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
import com.pasquali.vagas.domain.enums.TipoAcao;

import lombok.Builder;

@Entity
@Builder
public class LogAcao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TIPO_ACAO", length = 1)
	private Integer tipoAcao;

	@Column(name = "TABELA", length = 35)
	private String tabela;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA")
	private Date data;

	@Column(name = "HORA")
	private String  hora;
	
	@Column(name = "DESCRICAO", length = 255)
	private String descricao;

	@Column(name = "DESCRICAO_ACAO", length = 2048)
	private String descricaoAcao;

	// Relation
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public LogAcao() {}
	
	public LogAcao(Integer id, TipoAcao tipoAcao, String tabela, Date data, String hora, String descricao, String descricaoAcao,
			Usuario usuario) {
		super();
		this.id = id;
		this.tipoAcao = tipoAcao.getCod();
		this.tabela = tabela;
		this.data = data;
		this.hora = hora;
		this.descricao = descricao;
		this.descricaoAcao = descricaoAcao;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "LogAcao [id=" + id + ", tipoAcao=" + tipoAcao + ", tabela=" + tabela + ", data=" + data + ", hora="
				+ hora + ", descricao=" + descricao + ", descricaoAcao=" + descricaoAcao + ", usuario=" + usuario + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoAcao getTipoAcao() {
		return TipoAcao.toEnum(tipoAcao);
	}

	public void setTipoAcao(TipoAcao tipoAcao) {
		this.tipoAcao = tipoAcao.getCod();
	}

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setTipoAcao(Integer tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoAcao() {
		return descricaoAcao;
	}

	public void setDescricaoAcao(String descricaoAcao) {
		this.descricaoAcao = descricaoAcao;
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
		LogAcao other = (LogAcao) obj;
		return Objects.equals(id, other.id);
	}

	public void setUsuario(Object setId) {
		// TODO Auto-generated method stub
		
	}

}
