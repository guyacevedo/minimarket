package io.github.guyacevedo.minimarket.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import io.github.guyacevedo.minimarket.domain.dto.Product;
import io.github.guyacevedo.minimarket.persistence.entity.Producto;



/**
 * @Title: ProductoConverter.java
 * @Package io.github.guyacevedo.minimarket.persistence.converter
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-10:27:33 p. m.
 * @version V1.0
 */
@Component("productoConverter")
public class ProductoConverter {

	public List<Product> convertirLista(List<Producto> productos) {
		List<Product> products = new ArrayList<Product>();

		for (Producto producto : productos) {
			products.add(new Product(producto));
		}

		return products;
	}
	
}
