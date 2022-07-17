package com.pasquali.vagas.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pasquali.vagas.domain.VagaStatus;
import com.pasquali.vagas.domain.enums.Registro;

public class VagaStatusDTO {

	private Integer id;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 5, max = 64, message = "O tamanho deve ser entre 5 a 64 caracteres")
	private String statusNome;

	@NotNull
	private Registro ativo;

	public VagaStatusDTO() {}
	
	public VagaStatusDTO(VagaStatus obj) {
		id = obj.getId();
		statusNome = obj.getStatusNome();
		ativo = obj.getAtivo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusNome() {
		return statusNome;
	}

	public void setStatusNome(String statusNome) {
		this.statusNome = statusNome;
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
