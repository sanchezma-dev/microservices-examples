package micro.usuario.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import micro.usuario.api.dto.UsuarioDTO;
import micro.usuario.api.service.UsuarioMapper;
import micro.usuario.api.service.UsuarioService;
import micro.usuario.model.repository.UsuarioRepository;

public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private UsuarioMapper mapper;

	@Override
	public List<UsuarioDTO> findAll() {
		return repo.findAll().stream().map(e -> mapper.toDTO(e)).toList();
	}

}
