package com.pasquali.vagas.domain.enums;

public enum Permissao {

	SIM(1,"Sim"),
	NAO(0,"Não");
	
	private int cod;
	private String descricao;
	
	private Permissao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static Permissao toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for(Permissao x : Permissao.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
