package com.pasquali.vagas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Empresa;
import com.pasquali.vagas.dto.EmpresaDTO;
import com.pasquali.vagas.repositories.EmpresaRepository;
import com.pasquali.vagas.services.exception.DataIntegrityException;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa buscar(Integer id) {
		Optional<Empresa> obj = empresaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Empresa.class.getName()));
	}
	
	public List<Empresa> listar() {
		return empresaRepository.findAll();
	}
	
	public Empresa inserindo(Empresa obj) {
		obj.setId(null);
		return empresaRepository.save(obj);
	}
	
	public Empresa alterando(Empresa obj) {
		Empresa newObj = buscar(obj.getId());
		alterandoDados(newObj, obj);
		return empresaRepository.save(obj); 
	}
	
	public Page<Empresa> paginacao(Integer page, Integer linesPerPage, String orderBy , String direction) {
		PageRequest pages = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return empresaRepository.findAll(pages);
	}
	
	public void deletando(Integer id) {
		buscar(id);
		try {
			empresaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Área que possui dependência em outra Tabela!");
		}
	}
	
	public Empresa fromDTO(EmpresaDTO objDto) {
		return new Empresa(objDto.getId(), objDto.getNomeEmpresa(), objDto.getEndereco(), 
				objDto.getNumero(),objDto.getComplemento(),objDto.getBairro(),objDto.getCep(),
				objDto.getWhatsapp(),objDto.getTelefone(),objDto.getCelular(),objDto.getEmail(),
				objDto.getAtivo(),null);
	}
	
	private void alterandoDados(Empresa newObj, Empresa obj) {
		newObj.setNomeEmpresa(obj.getNomeEmpresa());
		newObj.setEndereco(obj.getEndereco());
		newObj.setNumero(obj.getNumero());
		newObj.setComplemento(obj.getComplemento());
		newObj.setBairro(obj.getBairro());
		newObj.setCep(obj.getCep());
		newObj.setWhatsapp(obj.getWhatsapp());
		newObj.setTelefone(obj.getTelefone());
		newObj.setCelular(obj.getCelular());
		newObj.setEmail(obj.getEmail());
		newObj.setCidade(obj.getCidade());		
		newObj.setAtivo(obj.getAtivo());
	}
}
