package microservicios.app.contratos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import microservicios.app.contratos.model.entity.IntermediarioEntity;

public interface IntermediarioRepository extends JpaRepository<IntermediarioEntity, Long> {

}
