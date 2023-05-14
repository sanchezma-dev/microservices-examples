package microservicios.app.usuarios.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import microservicios.app.usuarios.model.entity.UsuarioEntity;

//MongoRepository incluye los mismos métodos que jpaRepository
public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {

	UsuarioEntity findByCodigo(String codigo);

	UsuarioEntity deleteByCodigo(String codigo);
}
