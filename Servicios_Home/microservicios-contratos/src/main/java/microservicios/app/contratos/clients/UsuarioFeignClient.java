package microservicios.app.contratos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import microservicios.app.contratos.api.dto.UsuarioDto;

@FeignClient(name = "microservicio-usuarios")
public interface UsuarioFeignClient {

	@GetMapping("/usuario/ver/{codigo}") // Misma ruta que en el controller de usuario
	public UsuarioDto verUsuarioCodigo(@PathVariable final String codigo);

}
