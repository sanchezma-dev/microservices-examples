package microservicios.app.contratos.business.service.impl;

import org.springframework.stereotype.Service;

import microservicios.app.contratos.api.service.IntermediarioService;
import microservicios.app.contratos.model.entity.IntermediarioEntity;
import microservicios.app.contratos.model.repository.IntermediarioRepository;
import microservicios.commons.services.CommonServiceImpl;

@Service
public class IntermediarioServiceImpl extends CommonServiceImpl<IntermediarioEntity, IntermediarioRepository>
		implements IntermediarioService {

}
