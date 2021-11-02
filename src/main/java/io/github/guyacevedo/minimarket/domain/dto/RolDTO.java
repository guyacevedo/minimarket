package io.github.guyacevedo.minimarket.domain.dto;



import io.github.guyacevedo.minimarket.persistence.entity.Rol;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Title: RolDTO.java
 * @Package io.github.guyacevedo.minimarket.domain.dto
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:23:42 p. m.
 * @version V1.0
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class RolDTO {

	@Getter
	@Setter
	private long id;

	@Getter
	@Setter
	private String nombre;

	public RolDTO(Rol rol) {
		this.id = rol.getId();
		this.nombre = rol.getNombre();
	}

}
