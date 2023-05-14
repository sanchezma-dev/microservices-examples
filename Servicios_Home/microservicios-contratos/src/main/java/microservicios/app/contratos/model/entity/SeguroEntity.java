package microservicios.app.contratos.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import microservicios.app.contratos.api.dto.UsuarioDto;

@Data // Anotación (que incluye getter y setter, constructor..) lombok
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seguros")
public class SeguroEntity {

	@Id
	// Anotación autoincremental
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "X_ID", nullable = false)
	private Long id;

	// Relación unidireccional
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASE_X_ASEGURADORA", referencedColumnName = "X_ID", nullable = false)
	// Evita el error de serialización al tener el FetchType.LAZY
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private AseguradoraEntity aseguradora;

	// Relación unidireccional
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INT_X_INTERMEDIARIO", referencedColumnName = "X_ID", nullable = false)
	// Evita el error de serialización al tener el FetchType.LAZY
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private IntermediarioEntity intermediario;

	@Column(name = "C_COD_USUARIO", nullable = false, length = 5)
	private String codUsuario;

	@Transient
	private UsuarioDto usuario;

	@NotEmpty // Anotaciones de javax.validation
	@Column(name = "T_TIPO", nullable = false, length = 20)
	private String tipo;

	@Column(name = "F_FECHA_INICIO")
	@JsonFormat(pattern = "dd/MM/yyyy") // Control de fechas
	private LocalDate fechaInicio;

	@Column(name = "F_FECHA_FIN")
	@JsonFormat(pattern = "dd/MM/yyyy") // Control de fechas
	private LocalDate fechaFin;

	@Column(name = "T_DESCRIPCION", length = 150)
	private String descripcion;

}
