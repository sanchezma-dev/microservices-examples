

package microservicios.app.contratos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservicios.app.contratos.api.dto.UsuarioDto;
import microservicios.app.contratos.api.service.SeguroService;
import microservicios.app.contratos.model.entity.SeguroEntity;
import microservicios.commons.controller.CommonController;

@RestController
@RequestMapping("seguro")
public class SeguroController extends CommonController<SeguroEntity, SeguroService> {

//	@Autowired
//	private SeguroService servSeguro;//FIXME Hereda el service que hay en CommonController

	@Override
	@GetMapping // FIXME METER EN LA LISTA SEGURO, LOS USUARIOS HACIENDO UNA PETICIÓN FEIGN
	public ResponseEntity<?> listar() {
		final List<SeguroEntity> seguros = service.findAll();
		for (final SeguroEntity s : seguros) {
			final UsuarioDto usuarioDto = service.verUsuarioCodigo(s.getCodUsuario());
			if (usuarioDto != null) {
				s.setUsuario(usuarioDto);
			}
		}
		return ResponseEntity.ok().body(seguros);
	}

	@PutMapping("/editar/{idSeguro}")
	public ResponseEntity<?> editar(@RequestBody final SeguroEntity objForm, @PathVariable final Long idSeguro) {
		final Optional<SeguroEntity> seguroDB = service.findById(idSeguro);
		if (seguroDB.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		// FIXME Crear método privado para el seteo del guardado, con su validaciones
		final SeguroEntity seguroGuardado = seguroDB.get();
		seguroGuardado.setAseguradora(objForm.getAseguradora());
		seguroGuardado.setIntermediario(objForm.getIntermediario());
		seguroGuardado.setTipo(objForm.getTipo());
		seguroGuardado.setFechaInicio(objForm.getFechaInicio());
		seguroGuardado.setFechaFin(objForm.getFechaFin());
		service.save(seguroGuardado);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(seguroGuardado));

	}

}
