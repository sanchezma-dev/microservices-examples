package micro.usuario.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "usuarios")
public class UsuarioEntity {

	@Id
	private String id;

	/** Nombre único del usuario */
	@Indexed(unique = true)
	private String nombre;

	/** Email único del usuario */
	@Indexed(unique = true)
	private String email;
	
	/** Password del usuario */
	private String pass;

}
