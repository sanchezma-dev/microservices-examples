package micro.usuario.api.convert;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import micro.usuario.api.dto.UsuarioDTO;
import micro.usuario.model.entity.UsuarioEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

	UsuarioEntity toEntity(UsuarioDTO usuarioDto);

	UsuarioDTO toDTO(UsuarioEntity usuarioEntity);
}
