package microservicios.app.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservicios.app.usuarios.api.service.UsuarioService;
import microservicios.app.usuarios.model.entity.UsuarioEntity;

@RestController // equivale a @Controller más @ResponseBody. -es más propio de api o servicios
				// web
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/ver/{codigo}")
	public ResponseEntity<?> ver(@PathVariable final String codigo) {
		final UsuarioEntity usuario = service.findByCodigo(codigo);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody final UsuarioEntity usuario) {
		// FIXME Controlar para que el código sea único
		final UsuarioEntity usu = service.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usu);
	}

	@PutMapping("/editar/{codigo}")
	public ResponseEntity<?> editar(@RequestBody final UsuarioEntity usuario, @PathVariable final String codigo) {
		final UsuarioEntity usuarioBD = service.findByCodigo(codigo);
		if (usuarioBD == null) {
			return ResponseEntity.notFound().build();
		}

		final UsuarioEntity usuarioGuradado = usuarioBD;
		usuarioGuradado.setNombre(usuario.getNombre());
		usuarioGuradado.setApellido1(usuario.getApellido1());
		usuarioGuradado.setApellido2(usuario.getApellido2());
		usuarioGuradado.setEmail(usuario.getEmail());
		service.save(usuarioGuradado);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioGuradado));

	}

	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<?> eliminar(@PathVariable final String codigo) {
		service.deleteByCodigo(codigo);
		// FIXME Poner mensaje de éxito operación

		return ResponseEntity.noContent().build();
	}

}
