package io.github.guyacevedo.minimarket.domain.dto;

import io.github.guyacevedo.minimarket.persistence.entity.Categoria;
import lombok.Data;

/**
 * @Title: Category.java
 * @Package io.github.guyacevedo.apimarket.domain.dto
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo E-mail: guy.acevedoa@gmail.com
 * @date 31/10/2021-12:28:01 a. m.
 * @version V1.0
 */

@Data
public class Category {

	private int id;
	private String category;
	private boolean active;
	
	public Category(Categoria categoria) {
		this.id = categoria.getId();
		this.category = categoria.getDescripcion();
		this.active = categoria.getEstado();
	}

}
