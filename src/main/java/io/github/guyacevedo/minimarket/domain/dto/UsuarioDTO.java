package io.github.guyacevedo.minimarket.domain.dto;

import java.util.HashSet;
import java.util.Set;

import io.github.guyacevedo.minimarket.persistence.entity.Rol;
import io.github.guyacevedo.minimarket.persistence.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Title: UsuarioDTO.java
 * @Package io.github.guyacevedo.minimarket.domain.dto
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:23:07 p. m.
 * @version V1.0
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class UsuarioDTO {

	@Getter
	@Setter
	private long id;

	@Getter
	@Setter
	private String nombres;

	@Getter
	@Setter
	private String apellidos;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private boolean activo;

	@Getter
	@Setter
	private Set<RolDTO> roles = new HashSet<>();

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nombres = usuario.getNombres();
		this.apellidos = usuario.getApellidos();
		this.email = usuario.getEmail();
		this.password = usuario.getPassword();
		this.activo = usuario.isActivo();
		this.roles = convertirRolesARolesDTO(usuario.getRoles());

	}

	/**
	 * @param roles
	 */
	private Set<RolDTO> convertirRolesARolesDTO(Set<Rol> roles) {
		Set<RolDTO> rolesConvertidos = new HashSet<>();
		for (Rol rol : roles) {
			rolesConvertidos.add(new RolDTO(rol));
		}
		return rolesConvertidos;
	}

}
