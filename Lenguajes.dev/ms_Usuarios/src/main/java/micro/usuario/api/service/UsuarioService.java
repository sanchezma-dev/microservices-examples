package micro.usuario.api.service;

import java.util.List;

import micro.usuario.api.dto.UsuarioDTO;

public interface UsuarioService {
	
	/**
	 * Devuelve la lista de usuarios registrados
	 * @return lista de usuarios
	 */
	public List<UsuarioDTO> findAll();

}
