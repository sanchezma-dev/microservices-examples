package microservicios.app.usuarios.model.entity;

import org.springframework.data.annotation.Id;//FIXME Importante para trabajar sin jpa, nada de persistence
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data // Anotación (que incluye getter y setter, constructor..) lombok
@Document(collection = "usuarios")
public class UsuarioEntity {

	@Id
	private String id;

	@Indexed(unique = true)
	private String codigo;

	private String nombre;

	private String apellido1;

	private String apellido2;

	private String email;

}
