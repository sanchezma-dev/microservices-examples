package microservicios.app.usuarios.api.service;

import java.util.List;

import microservicios.app.usuarios.model.entity.UsuarioEntity;

public interface UsuarioService {

	public List<UsuarioEntity> findAll();

	public UsuarioEntity findByCodigo(final String codigo);

	public UsuarioEntity save(final UsuarioEntity entity);

	public void deleteByCodigo(final String codigo);

}
