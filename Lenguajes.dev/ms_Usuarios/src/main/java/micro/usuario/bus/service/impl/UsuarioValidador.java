package micro.usuario.bus.service.impl;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import micro.usuario.api.dto.UsuarioDTO;

public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(final Class<?> clazz) {
		return UsuarioDTO.class.equals(clazz);
	}

	@Override
	public void validate(final Object target, final Errors errors) {
		final UsuarioDTO usuarioDTO = (UsuarioDTO) target;
		// Validación personalizada
		if (usuarioDTO.getNombre().isEmpty()) {
			errors.reject("El nombre no puede ser vacio");
		}
	}
}
