package micro.usuario.api.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
	
	/** Identificador del usuario */
	private String id;

	/** Nombre único del usuario */
	private String nombre;
	
	/** Password del usuario */
	private String pass;
}
