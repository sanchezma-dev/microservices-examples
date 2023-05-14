package microservicios.app.contratos.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Anotación (que incluye getter y setter, constructor..) lombok
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

	private String nombre;

	private String apellido1;

}
