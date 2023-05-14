package microservicios.app.contratos.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservicios.app.contratos.api.service.IntermediarioService;
import microservicios.app.contratos.model.entity.IntermediarioEntity;
import microservicios.commons.controller.CommonController;

@RestController
@RequestMapping("intermediario")
public class IntermediarioController extends CommonController<IntermediarioEntity, IntermediarioService> {

//	@Autowired
//	private IntermediarioService service;//FIXME Hereda el service que hay en CommonController

	@PutMapping("/editar/{idIntermediario}")
	public ResponseEntity<?> editar(@RequestBody final IntermediarioEntity objForm,
			@PathVariable final Long idIntermediario) {
		final Optional<IntermediarioEntity> interDB = service.findById(idIntermediario);
		if (interDB.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		// FIXME Crear método privado para el seteo del guardado, con su validaciones
		final IntermediarioEntity interGuardado = interDB.get();
		interGuardado.setNombre(objForm.getNombre());
		interGuardado.setApellido1(objForm.getApellido1());
		interGuardado.setApellido2(objForm.getApellido2());
		interGuardado.setTelefono(objForm.getTelefono());
		interGuardado.setEmail(objForm.getEmail());
		service.save(interGuardado);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(interGuardado));

	}
}
