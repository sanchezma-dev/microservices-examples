package microservicios.app.contratos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import microservicios.app.contratos.model.entity.SeguroEntity;

public interface SeguroRepository extends JpaRepository<SeguroEntity, Long> {

}
