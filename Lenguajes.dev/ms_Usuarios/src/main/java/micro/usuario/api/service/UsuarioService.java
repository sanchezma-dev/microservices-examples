package micro.usuario.api.service;

import java.util.List;

import micro.usuario.api.dto.UsuarioDTO;

/**
 * @author josem
 *
 */
public interface UsuarioService {

	/**
	 * Devuelve la lista de usuarios registrados
	 *
	 * @return lista de usuarios
	 */
	public List<UsuarioDTO> findAll();

	/**
	 * Método encargado de guardar en la base de datos un usuario o actualizarlo y
	 * devolver un usuarioDTO
	 *
	 * @param usuario usuarioDTO
	 * @return usuarioDTO
	 */
	public UsuarioDTO saveUsuario(final UsuarioDTO usuario);

	/**
	 * Devuelve verdadero si encuentra al usuario que coincida con el nombre pasado
	 * por parámetro, false en caso contrario
	 *
	 * @param nombre nombre del usuario
	 * @return true o false
	 */
	public boolean existeUsuario(final String nombre);

	/**
	 * Elimina al usuario que coincida con el nombre pasado por parámetros
	 *
	 * @param nombre nombre del usuario
	 */
	public void borrarUsuario(String nombre);
}
