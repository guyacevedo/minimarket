package io.github.guyacevedo.minimarket.domain.dto;

import io.github.guyacevedo.minimarket.persistence.entity.Producto;
import lombok.Data;

/**
 * @Title: Product.java
 * @Package io.github.guyacevedo.apimarket.domain.dto
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 31/10/2021-12:28:15 a. m.
 * @version V1.0
 */
@Data
public class Product {

	private int id;
	private String name;
	private int categoryId;
	private double price;
	private int stock;
	private boolean active;
	private Category category;
	
	public Product(Producto producto) {
		this.id = producto.getId();
		this.name = producto.getNombre();
		this.price = producto.getPrecioVenta();
		this.stock = producto.getStock();
		this.active = producto.getEstado();
		this.categoryId = producto.getIdCategoria();
		this.category = new Category(producto.getCategoria());
	}
}
