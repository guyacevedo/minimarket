package io.github.guyacevedo.minimarket.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import io.github.guyacevedo.minimarket.domain.dto.UsuarioDTO;
import io.github.guyacevedo.minimarket.persistence.entity.Usuario;

/**
 * @Title: UsuarioConverter.java
 * @Package io.github.guyacevedo.minimarket.persistence.converter
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:25:19 p. m.
 * @version V1.0
 */
@Component("usuarioConverter")
public class UsuarioConverter {

	public List<UsuarioDTO> convertirLista(List<Usuario> usuarios) {
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();

		for (Usuario usuario : usuarios) {
			usuariosDTO.add(new UsuarioDTO(usuario));
		}

		return usuariosDTO;
	}
}
