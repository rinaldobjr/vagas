package com.pasquali.vagas.domain.enums;

public enum Registro {

	ATIVO(1,"Ativo"),
	INATIVO(0,"Inativo");
	
	private int cod;
	private String descricao;
	
	private Registro(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static Registro toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for(Registro x : Registro.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
