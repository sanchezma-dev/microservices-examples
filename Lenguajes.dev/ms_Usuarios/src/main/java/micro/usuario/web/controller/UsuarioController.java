package micro.usuario.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping
	public ResponseEntity<?> listar() {
		final RespuestaDTO respuesta = new RespuestaDTO();
		respuesta.setExisteErrores(false);
		final List<UsuarioDTO> listaUsuarios = servUsuario.findAll();
		if (CollectionUtils.isNotEmpty(listaUsuarios)) {
			respuesta.setListaUsuarioDto(listaUsuarios);
			return ResponseEntity.ok().body(respuesta);
		}
		respuesta.setExisteErrores(true);
		return ResponseEntity.badRequest().body(respuesta);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crear(@Valid @RequestBody final UsuarioDTO usuarioDto, final BindingResult bindingResult) {
		final RespuestaDTO respuesta = new RespuestaDTO();
		respuesta.setExisteErrores(false);
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

	@DeleteMapping("/eliminar/{nombre}")
	public ResponseEntity<?> eliminar(@PathVariable final String nombre) {
		final RespuestaDTO respuesta = new RespuestaDTO();
		respuesta.setExisteErrores(false);
		if (servUsuario.existeUsuario(nombre)) {
			servUsuario.borrarUsuario(nombre);
			return ResponseEntity.ok(respuesta);
		}
		final List<String> errores = new ArrayList<>();
		errores.add("No se encontró un usuario con el nombre especificado");
		respuesta.setErrores(errores);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	}
}
