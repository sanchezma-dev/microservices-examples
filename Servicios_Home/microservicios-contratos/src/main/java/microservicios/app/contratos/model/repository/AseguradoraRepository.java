package microservicios.app.contratos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import microservicios.app.contratos.model.entity.AseguradoraEntity;

public interface AseguradoraRepository extends JpaRepository<AseguradoraEntity, Long> {

}
