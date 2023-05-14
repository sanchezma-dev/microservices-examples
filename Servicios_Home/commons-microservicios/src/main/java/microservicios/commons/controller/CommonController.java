package microservicios.commons.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import microservicios.commons.services.CommonService;

//@RestController FIXME No se pone ya que es una librería
public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;// FIXME Protected para poder hacer la herencia

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/ver/{id}")
	public ResponseEntity<?> ver(@PathVariable final Long id) {
		final Optional<E> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody final E entity) {
		final E entidad = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entidad);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable final Long id) {
		service.deleteById(id);

		return ResponseEntity.noContent().build();
	}

}
