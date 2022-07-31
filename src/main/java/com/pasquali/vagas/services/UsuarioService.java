package com.pasquali.vagas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pasquali.vagas.domain.Usuario;
import com.pasquali.vagas.dto.UsuarioDTO;
import com.pasquali.vagas.repositories.UsuarioRepository;
import com.pasquali.vagas.services.exception.DataIntegrityException;
import com.pasquali.vagas.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario buscar(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}


	public Usuario inserindo(Usuario obj) {
		obj.setId(null);
		return usuarioRepository.save(obj);
	}

	public Usuario alterando(Usuario obj) {
		Usuario newObj = buscar(obj.getId());
		alterandoDados(newObj, obj);
		return usuarioRepository.save(obj); 
	}
	
	public void deletando(Integer id) {
		buscar(id);
		try {
			usuarioRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Área que possui dependência em outra Tabela!");
		}
	}
	
	public Page<Usuario> paginacao(Integer page, Integer linesPerPage, String orderBy , String direction) {
		PageRequest pages = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return usuarioRepository.findAll(pages);
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getLogin(), objDto.getSenha(),
				objDto.getNomeCompleto(), objDto.getNomeApelido(), objDto.getTipoUsuario(),
				objDto.getTelefone(), objDto.getCelular(), objDto.getEmail(),
				objDto.getEnviaEmail(), objDto.getWhatsapp(), objDto.getSexo(),
				objDto.getAtivo(),objDto.getEstado());
	}
	
	private void alterandoDados(Usuario newObj, Usuario obj) {
		newObj.setLogin(obj.getLogin());
		newObj.setSenha(obj.getSenha());
		newObj.setNomeCompleto(obj.getNomeCompleto());
		newObj.setNomeApelido(obj.getNomeApelido());
		newObj.setTipoUsuario(obj.getTipoUsuario());
		newObj.setTelefone(obj.getTelefone());
		newObj.setCelular(obj.getCelular());
		newObj.setEmail(obj.getEmail());
		newObj.setEnviaEmail(obj.getEnviaEmail());
		newObj.setWhatsapp(obj.getWhatsapp());
		newObj.setSexo(obj.getSexo());
		newObj.setAtivo(obj.getAtivo());
		newObj.setEstado(obj.getEstado());
	}
}
