package microservicios.commons.services;

import java.util.List;
import java.util.Optional;

public interface CommonService<E> {

	// FIXME Incluir javadoc
	public List<E> findAll();

	public Optional<E> findById(final Long id);

	public E save(final E entity);

	public void deleteById(final Long id);

}
