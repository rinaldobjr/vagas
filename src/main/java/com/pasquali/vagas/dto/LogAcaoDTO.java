package com.pasquali.vagas.dto;

import java.util.Date;

import com.pasquali.vagas.domain.LogAcao;
import com.pasquali.vagas.domain.enums.TipoAcao;

public class LogAcaoDTO {

	private Integer id;
	private TipoAcao tipoAcao;
	private String tabela;
	private Date data;
	private String  hora;
	private String descricao;
	private String descricaoAcao;
	
	public LogAcaoDTO() {}
	
	public LogAcaoDTO(LogAcao obj) {
		id = obj.getId();
		tipoAcao = obj.getTipoAcao();
		tabela = obj.getTabela();
		data = obj.getData();
		hora = obj.getHora();
		descricao = obj.getDescricao();
		descricaoAcao = obj.getDescricaoAcao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoAcao getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(TipoAcao tipoAcao) {
		this.tipoAcao = tipoAcao;
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
	
}
