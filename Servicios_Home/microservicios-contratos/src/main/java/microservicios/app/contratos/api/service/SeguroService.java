package microservicios.app.contratos.api.service;

import microservicios.app.contratos.api.dto.UsuarioDto;
import microservicios.app.contratos.model.entity.SeguroEntity;
import microservicios.commons.services.CommonService;

public interface SeguroService extends CommonService<SeguroEntity> {

	// FIXME javadoc
	// FIXME Metodo del cliente feign
	public UsuarioDto verUsuarioCodigo(final String codigo);
}
