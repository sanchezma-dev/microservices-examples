package microservicios.app.contratos.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservicios.app.contratos.api.service.AseguradoraService;
import microservicios.app.contratos.model.entity.AseguradoraEntity;
import microservicios.commons.controller.CommonController;

@RestController
@RequestMapping("aseguradora")
public class AseguradoraController extends CommonController<AseguradoraEntity, AseguradoraService> {

//	@Autowired
//	private AseguradoraService service;//FIXME Hereda el service que hay en CommonController

	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar(@RequestBody final AseguradoraEntity objForm,
			@PathVariable final Long idAseguradora) {
		final Optional<AseguradoraEntity> aseguradoraBD = service.findById(idAseguradora);
		if (aseguradoraBD.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		// FIXME Crear método privado para el seteo del guardado, con su validaciones
		final AseguradoraEntity aseguradoraGuradado = aseguradoraBD.get();
		aseguradoraGuradado.setNombre(objForm.getNombre());
		aseguradoraGuradado.setTelefono(objForm.getTelefono());
		aseguradoraGuradado.setEmail(objForm.getEmail());
		aseguradoraGuradado.setDireccion(objForm.getDireccion());
		service.save(aseguradoraGuradado);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(aseguradoraGuradado));

	}
}
