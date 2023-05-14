package micro.usuario.api.service;

import org.mapstruct.Mapper;

import micro.usuario.api.dto.UsuarioDTO;
import micro.usuario.model.entity.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	UsuarioEntity toEntity(UsuarioDTO usuarioDto);
	
	UsuarioDTO toDTO(UsuarioEntity usuarioEntity);

}
