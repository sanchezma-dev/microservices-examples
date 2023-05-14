package microservicios.app.contratos.business.service.impl;

import org.springframework.stereotype.Service;

import microservicios.app.contratos.api.service.AseguradoraService;
import microservicios.app.contratos.model.entity.AseguradoraEntity;
import microservicios.app.contratos.model.repository.AseguradoraRepository;
import microservicios.commons.services.CommonServiceImpl;

@Service
public class AseguradoraServiceImpl extends CommonServiceImpl<AseguradoraEntity, AseguradoraRepository>
		implements AseguradoraService {

}
