package micro.usuario.bus.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import micro.usuario.api.convert.UsuarioMapper;
import micro.usuario.api.dto.UsuarioDTO;
import micro.usuario.api.service.UsuarioService;
import micro.usuario.model.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	@Autowired
	private UsuarioMapper mapper;

	@Override
	public List<UsuarioDTO> findAll() {
		return repo.findAll().stream().map(e -> mapper.toDTO(e)).collect(Collectors.toList());
	}

	@Override
	public UsuarioDTO saveUsuario(final UsuarioDTO usuario) {
		return mapper.toDTO(repo.save(mapper.toEntity(usuario)));
	}

	@Override
	public boolean existeUsuario(final String nombre) {
		return repo.existsByNombre(nombre);
	}

	@Override
	public void borrarUsuario(final String nombre) {
		repo.deleteByNombre(nombre);
	}

}