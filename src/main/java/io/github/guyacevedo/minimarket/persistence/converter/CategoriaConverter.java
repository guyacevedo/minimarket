package io.github.guyacevedo.minimarket.persistence.converter;
/**
 * @Title: CategoriaConverter.java
 * @Package io.github.guyacevedo.minimarket.persistence.converter
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-10:25:03 p. m.
 * @version V1.0
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import io.github.guyacevedo.minimarket.domain.dto.Category;
import io.github.guyacevedo.minimarket.persistence.entity.Categoria;


@Component("categoriaConverter")
public class CategoriaConverter {

	public List<Category> convertirLista(List<Categoria> categorias) {
		List<Category> categories = new ArrayList<Category>();

		for (Categoria categoria : categorias) {
			categories.add(new Category(categoria));
		}

		return categories;
	}
}
