package microservicios.app.usuarios.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservicios.app.usuarios.api.service.UsuarioService;
import microservicios.app.usuarios.model.entity.UsuarioEntity;
import microservicios.app.usuarios.model.repository.UsuarioRepository;

@Service // En la implementación se pone la anotación
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	@Override
//	@Transactional(readOnly = true) //FIXME En mongodb no se utiliza @Transactional
	public List<UsuarioEntity> findAll() {
		return repo.findAll();
	}

	@Override
	public UsuarioEntity save(final UsuarioEntity usuario) {
		return repo.save(usuario);
	}

	@Override
	public void deleteByCodigo(final String codigo) {
		repo.deleteByCodigo(codigo);
	}

	@Override
	public UsuarioEntity findByCodigo(final String codigo) {
		return repo.findByCodigo(codigo);
	}

}
