package com.pasquali.vagas;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pasquali.vagas.domain.Area;
import com.pasquali.vagas.domain.Cargo;
import com.pasquali.vagas.domain.Cidade;
import com.pasquali.vagas.domain.Contrato;
import com.pasquali.vagas.domain.Empresa;
import com.pasquali.vagas.domain.Estado;
import com.pasquali.vagas.domain.InfoContato;
import com.pasquali.vagas.domain.LocalTrabalho;
import com.pasquali.vagas.domain.LogAcao;
import com.pasquali.vagas.domain.LogEnvioEmail;
import com.pasquali.vagas.domain.Nivel;
import com.pasquali.vagas.domain.Usuario;
import com.pasquali.vagas.domain.Vaga;
import com.pasquali.vagas.domain.VagaStatus;
import com.pasquali.vagas.domain.enums.Permissao;
import com.pasquali.vagas.domain.enums.Registro;
import com.pasquali.vagas.domain.enums.Sexo;
import com.pasquali.vagas.domain.enums.TipoAcao;
import com.pasquali.vagas.domain.enums.TipoUsuario;
import com.pasquali.vagas.repositories.AreaRepository;
import com.pasquali.vagas.repositories.CargoRepository;
import com.pasquali.vagas.repositories.CidadeRepository;
import com.pasquali.vagas.repositories.ContratoRepository;
import com.pasquali.vagas.repositories.EmpresaRepository;
import com.pasquali.vagas.repositories.EstadoRepository;
import com.pasquali.vagas.repositories.InfoContatoRepository;
import com.pasquali.vagas.repositories.LocalTrabalhoRepository;
import com.pasquali.vagas.repositories.LogAcaoRepository;
import com.pasquali.vagas.repositories.LogEnvioEmailRepository;
import com.pasquali.vagas.repositories.NivelRepository;
import com.pasquali.vagas.repositories.UsuarioRepository;
import com.pasquali.vagas.repositories.VagaRepository;
import com.pasquali.vagas.repositories.VagaStatusRepository;

@SpringBootApplication
public class VagasApplication implements CommandLineRunner{
	
	private CargoRepository cargoRepository;
	private CidadeRepository cidadeRepository;
	private EstadoRepository estadoRepository;
	private AreaRepository areaRepository;
	private NivelRepository nivelRepository;
	private ContratoRepository contratoRepository;
	private EmpresaRepository empresaRepository;
	private LocalTrabalhoRepository localRepository;
	private VagaRepository vagaRepository;
	private InfoContatoRepository infoContatoRepository;
	private VagaStatusRepository vagaStatusRepository;
	private UsuarioRepository usuarioRepository;
	private LogAcaoRepository logAcaoRepository;
	private LogEnvioEmailRepository logEnvioEmailRepository;
	
	public VagasApplication(CargoRepository cargoRepository, 
			CidadeRepository cidadeRepository, EstadoRepository estadoRepository,
			AreaRepository areaRepository, NivelRepository nivelRepository,
			ContratoRepository contratoRepository,EmpresaRepository empresaRepository,
			LocalTrabalhoRepository localRepository, VagaRepository vagaRepository,
			InfoContatoRepository infoContatoRepository, VagaStatusRepository vagaStatusRepository,
			UsuarioRepository usuarioRepository, LogAcaoRepository logAcaoRepository,
			LogEnvioEmailRepository logEnvioEmailRepository
			) {
		this.cargoRepository = cargoRepository;
		this.cidadeRepository = cidadeRepository;
		this.estadoRepository = estadoRepository;
		this.areaRepository = areaRepository;
		this.nivelRepository = nivelRepository;
		this.contratoRepository = contratoRepository;
		this.empresaRepository = empresaRepository;
		this.localRepository = localRepository;
		this.vagaRepository = vagaRepository;
		this.infoContatoRepository = infoContatoRepository;
		this.vagaStatusRepository = vagaStatusRepository;
		this.usuarioRepository = usuarioRepository;
		this.logAcaoRepository = logAcaoRepository;
		this.logEnvioEmailRepository = logEnvioEmailRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(VagasApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
		Cargo car1 = new Cargo(null, "Arquiteto de Infraestrutura", Registro.ATIVO);
		Cargo car2 = new Cargo(null, "Consultor Técnico Oracle", Registro.ATIVO);
		Cargo car3 = new Cargo(null, "Técnico De Suporte Remoto", Registro.ATIVO);
		cargoRepository.saveAll(Arrays.asList(car1,car2,car3));
		
		Estado est1 = new Estado(null, "São Paulo", Registro.ATIVO);
		Estado est2 = new Estado(null, "Minas Gerais", Registro.ATIVO);
		Estado est3 = new Estado(null, "Rio de Janeiro", Registro.ATIVO);
		
		Cidade c1 = new Cidade(null, "Jundiai", Registro.ATIVO, est1);
		Cidade c2 = new Cidade(null, "São Paulo", Registro.ATIVO, est1);
		Cidade c3 = new Cidade(null, "Uberlândia", Registro.ATIVO, est2);
		Cidade c4 = new Cidade(null, "Guanabara", Registro.ATIVO, est3);
		
		est1.getCidades().addAll(Arrays.asList(c1,c2));
		est2.getCidades().addAll(Arrays.asList(c3));
		est3.getCidades().addAll(Arrays.asList(c4));
		estadoRepository.saveAll(Arrays.asList(est1,est2,est3));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
		
		Area a1 = new Area(null, "Tecnologia da Informação","TI", Registro.ATIVO);
		Area a2 = new Area(null, "Recursos Humanos","RH", Registro.ATIVO);
		Area a3 = new Area(null, "FINANÇAS","FI", Registro.ATIVO);
		Area a4 = new Area(null, "CONTABILIDADE","CT", Registro.ATIVO);
		areaRepository.saveAll(Arrays.asList(a1,a2,a3,a4));
		
		Empresa e1 = new Empresa(null, "Empresa 1", "Rua Alta", "134", null, "Bairro da Hora", "18973-890", Permissao.SIM, null, "11 98709-5622", "email@empresa1.com.br", Registro.ATIVO, c1);
		Empresa e2 = new Empresa(null, "Empresa 2", "Rua Baixa", "245", null, "Bairro da Quebrada", "08543-390", Permissao.SIM, null, "11 93241-3421", "email@empresa2.com.br", Registro.ATIVO, c2);
		Empresa e3 = new Empresa(null, "Empresa 3", "Rua Media", "389", null, "Bairro da Curva", "38452-670", Permissao.NAO, null, "31 93709-7631", "email@empresa3.com.br", Registro.ATIVO, c3);
		empresaRepository.saveAll(Arrays.asList(e1,e2,e3));
		
		Nivel n1 = new Nivel(null, "Junior", Registro.ATIVO);
		Nivel n2 = new Nivel(null, "Pleno", Registro.ATIVO);
		Nivel n3 = new Nivel(null, "Senior", Registro.ATIVO);
		nivelRepository.saveAll(Arrays.asList(n1,n2,n3));
		
		LocalTrabalho l1 = new LocalTrabalho(null, "Home Office", Registro.ATIVO);
		LocalTrabalho l2 = new LocalTrabalho(null, "Hibrido", Registro.ATIVO);
		LocalTrabalho l3 = new LocalTrabalho(null, "Presencial", Registro.ATIVO);
		localRepository.saveAll(Arrays.asList(l1,l2,l3));
		
		Contrato ct1 = new Contrato(null,"PJ",Registro.ATIVO);
		Contrato ct2 = new Contrato(null,"CLT",Registro.ATIVO);
		Contrato ct3 = new Contrato(null,"ASSOCIADO",Registro.ATIVO);
		contratoRepository.saveAll(Arrays.asList(ct1,ct2,ct3));
		
		InfoContato inf1 = new InfoContato(null,"Claudia","11 978903240","claudia.brasil@pasquali.com.br",Permissao.SIM,Registro.ATIVO);
		infoContatoRepository.saveAll(Arrays.asList(inf1));
		
		VagaStatus vs1 = new VagaStatus(null,"CADASTRADA",Registro.ATIVO);
		VagaStatus vs2 = new VagaStatus(null,"LIBERADA",Registro.ATIVO);
		VagaStatus vs3 = new VagaStatus(null,"ALOCANDO",Registro.ATIVO);
		VagaStatus vs4 = new VagaStatus(null,"ENCERRADA",Registro.ATIVO);
		VagaStatus vs5 = new VagaStatus(null,"CANCELADA",Registro.ATIVO);
		vagaStatusRepository.saveAll(Arrays.asList(vs1,vs2,vs3,vs4,vs5));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		//Vaga v1 = new Vaga(null, null, null, null, null, null, null, null, null, car3, null, null, null, null, a2, null, e3);
		//Calendar.getInstance().getTime()  //DataHora
		Vaga v1 = new Vaga(null, "Resumo", "Obs", sdf.parse("2022/06/10 10:20"), null, null, 2, null, null, car1, n3, l1, ct1, inf1, a1, vs1, e1);
		vagaRepository.saveAll(Arrays.asList(v1));
		
		Usuario u1 = new Usuario(null, "admin", "admin", TipoUsuario.ADMIN, "Rinaldo Belisario Junior", "RinaldoBJr", null, "11 96908-3249", "rinaldobjr@gmail.com", 1, Permissao.SIM, Sexo.MASCULINO, Registro.ATIVO,est1,null,null);
		Usuario u2 = new Usuario(null, "rinaldobjr", "admin", TipoUsuario.EDITOR,"Rinaldo Belisario Junior", "RinaldoBJr", null, "11 96908-3249", "rinaldobjr@gmail.com", 1, Permissao.SIM, Sexo.MASCULINO, Registro.ATIVO, est1,null,null);
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		
		LogAcao la1 = new LogAcao(null,TipoAcao.UPDATE,"Usuario",sdf.parse("2022/06/12 15:34"),"Alteracao de Status","Obs TEXT",u2);
		LogAcao la2 = new LogAcao(null,TipoAcao.UPDATE,"Usuario",sdf.parse("2022/06/12 15:45"),"Alteracao de NomeCompleto","Obs TEXT",u2);
		logAcaoRepository.saveAll(Arrays.asList(la1,la2));
		
		//Calendar.getInstance().getTime()
		LogEnvioEmail le1 = new LogEnvioEmail(null, sdf.parse("2022/06/13 12:10"), 25, u2);
		LogEnvioEmail le2 = new LogEnvioEmail(null, sdf.parse("2022/06/13 12:11"), 30, u2);
		logEnvioEmailRepository.saveAll(Arrays.asList(le1,le2));	
		
		
	}
}
