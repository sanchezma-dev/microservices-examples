package micro.usuario.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import micro.usuario.api.dto.RespuestaDTO;
import micro.usuario.api.dto.UsuarioDTO;
import micro.usuario.api.service.UsuarioService;

@RestController
@RequestMapping("login")
public class UsuarioController {

	/** Servicio de usuario */
	@Autowired
	private UsuarioService servUsuario;

	/** Objeto de respuesta */
	@Autowired
	private RespuestaDTO respuesta;

	// Incializo el valor de respuesta
	@PostConstruct
	public void init() {
		respuesta.setExisteErrores(false);
	}

	@GetMapping
	public ResponseEntity<?> listar() {
		final String h = "Hola mundo";
		return ResponseEntity.ok().body(h);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crear(@Valid @RequestBody final UsuarioDTO usuarioDto, final BindingResult bindingResult) {
		// Validaciones
		if (bindingResult.hasErrors()) {
			respuesta.setExisteErrores(true);
			final List<String> errores = new ArrayList<>();
			for (final FieldError fieldError : bindingResult.getFieldErrors()) {
				errores.add(fieldError.getDefaultMessage());
			}
			respuesta.setErrores(errores);
			return ResponseEntity.badRequest().body(respuesta);
		}
		respuesta.setUsuarioDto(servUsuario.saveUsuario(usuarioDto));

		return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
	}
}
