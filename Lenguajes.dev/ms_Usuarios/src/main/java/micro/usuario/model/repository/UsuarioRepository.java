package micro.usuario.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import micro.usuario.model.entity.UsuarioEntity;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {

}
