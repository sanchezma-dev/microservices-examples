package micro.usuario.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import micro.usuario.model.entity.UsuarioEntity;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {

	/**
	 * Devuelve verdadero si encuentra al usuario que coincida con el nombre pasado
	 * por parámetro, false en caso contrario
	 *
	 * @param nombre nombre del usuario
	 * @return true o false
	 */
	public boolean existsByNombre(final String nombre);

	/**
	 * Elimina al usuario que coincida con el nombre pasado por parámetros
	 *
	 * @param nombre nombre del usuario
	 */
	public void deleteByNombre(String nombre);
}
