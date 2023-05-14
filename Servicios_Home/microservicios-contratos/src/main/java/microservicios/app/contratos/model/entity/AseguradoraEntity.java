package microservicios.app.contratos.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name = "aseguradoras")
@Data // Anotación (que incluye getter y setter, constructor..) lombok
public class AseguradoraEntity {
	// FIXME AÑADIR CODIGO A ASGURADDORA E INTERMEDIARIO

	@Id
	// Anotación autoincremental
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "X_ID", nullable = false)
	private Long id;

	@NotEmpty // Anotaciones de javax.validation
	@Column(name = "T_NOMBRE", nullable = false, length = 50)
	private String nombre;

	@NotEmpty
	@Column(name = "T_TELEFONO", nullable = false, length = 9)
	private String telefono;

	@Email
	@Column(name = "T_EMAIL", length = 100)
	private String email;

	@Column(name = "T_DIRECCION", length = 150)
	private String direccion;

}
