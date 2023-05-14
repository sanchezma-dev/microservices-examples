package microservicios.app.contratos.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservicios.app.contratos.api.dto.UsuarioDto;
import microservicios.app.contratos.api.service.SeguroService;
import microservicios.app.contratos.clients.UsuarioFeignClient;
import microservicios.app.contratos.model.entity.SeguroEntity;
import microservicios.app.contratos.model.repository.SeguroRepository;
import microservicios.commons.services.CommonServiceImpl;

@Service
public class SeguroServiceImpl extends CommonServiceImpl<SeguroEntity, SeguroRepository> implements SeguroService {

	@Autowired
	private UsuarioFeignClient client;

	@Override
	public UsuarioDto verUsuarioCodigo(final String codigo) {
		return client.verUsuarioCodigo(codigo);
	}

}
