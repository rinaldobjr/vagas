package com.pasquali.vagas.domain.enums;

public enum TipoUsuario {

	USUARIO(1,"Usuário/Visualizador de Dados"),
	EDITOR(2,"Editor de Dados"),
	GESTOR(3,"Gestor de Dados"),
	ADMIN(4,"Administrador");
	
	private int cod;
	private String descricao;
	
	private TipoUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static TipoUsuario toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for(TipoUsuario x : TipoUsuario.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
