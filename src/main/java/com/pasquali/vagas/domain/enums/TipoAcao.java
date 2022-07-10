package com.pasquali.vagas.domain.enums;

public enum TipoAcao {
	
	VISUAL(1,"Visualização de Registro"),
	CREATE(2,"Criação de Registro"),
	UPDATE(3,"Alteração de Dados"),
	STATUS(4,"Ativação/Inativação de Registro"),
	DELETE(5,"Deleção de Registro");
	
	private int cod;
	private String descricao;
	
	private TipoAcao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static TipoAcao toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for(TipoAcao x : TipoAcao.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
