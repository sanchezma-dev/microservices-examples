package micro.usuario.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UsuarioDTO {

	/** Identificador del usuario */
	private String id;

	@NotEmpty(message = "El nombre del usuario debe estar informado")
	/** Nombre único del usuario */
	private String nombre;

	@NotEmpty(message = "El campo email no puede estar vacío")
	@Email(message = "El formato del email no es el correcto")
	/** Email único del usuario */
	private String email;

	@NotEmpty(message = "La contraseña no puede estar vacía")
	/** Password del usuario */
	private String pass;
}
