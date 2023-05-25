package micro.usuario.api.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

/** Clase encargada de almacenar la respuesta a enviar a la petición */
@Component
@Data
public class RespuestaDTO {

	/** UsuarioDTO */
	private UsuarioDTO usuarioDto;

	/** Corresponde si la respuesta tiene errores o no */
	private Boolean existeErrores;

	/** Lista de errores */
	private List<String> errores;
}
