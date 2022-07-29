package com.pasquali.vagas.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.pasquali.vagas.domain.LogAcao;
import com.pasquali.vagas.domain.Usuario;
import com.pasquali.vagas.domain.enums.TipoAcao;
import com.pasquali.vagas.services.LogAcaoService;

import lombok.Builder;

@Builder
public class LogRegistro {

	@Autowired
	private LogAcaoService logAcaoService;
	
	public LogAcao registrar(TipoAcao tipo, String tabela, String descricao, String descricaoAcao,Usuario usuario) {
		LogAcao obj = new LogAcao();
//		obj.setTipoAcao(tipo);
//		obj.setTabela(tabela);
//		obj.setDescricao(descricao);
//		obj.setDescricaoAcao(descricaoAcao);
//		obj.setData(DataHora.dataHoje());
//		obj.setHora(DataHora.horaHoje());
//		//LogAcao log = new LogAcao(null,TipoAcao.VISUAL,"Area",DataHora.dataHoje(),"H",
//		                  //     "Listando Registro ","Listando os registros de ",2);
//		//Usuario user = new Usuario();
//		obj.setUsuario(usuario);
		return obj;
		
//		LogAcao obj = LogAcao.builder()
//				.tipoAcao(tipo)
//				.tabela(descricao)
//				.descricao(descricao)
//				.descricaoAcao(descricaoAcao)
//				.data(DataHora.dataHoje())
//				.hora(DataHora.horaHoje())
//				.Usuario(usuario)
//				.build();
//		logAcaoService.inserindo(obj);
	}


}
/*
Person.builder()
.name("Adam Savage")
.city("San Francisco")
.job("Mythbusters")
.job("Unchained Reaction")
.build();

		LogAcao log = new LogAcao(null,TipoAcao.VISUAL,"Area",DataHora.dataHoje(),"H","Listando Registro ","Listando os registros de ",2);
		logAcaoService.inserindo(log);
*/