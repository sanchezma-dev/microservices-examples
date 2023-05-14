package microservicios.commons.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

//@Service No es un componente que se inyecte, es una clase para la herencia
// E y R son de tipo Generic, R extiende de CrudRespotory así que tiene sus métodos
public class CommonServiceImpl<E, R extends CrudRepository<E, Long>> implements CommonService<E> {

	@Autowired
	protected R repository;

	@Override
	@Transactional(readOnly = true)
	public List<E> findAll() {
		return (List<E>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	// Optional lo implementa la interfaz crudRepository para controlar los valores
	// nulo
	public Optional<E> findById(final Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public E save(final E entity) {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(final Long id) {
		repository.deleteById(id);
	}

}
