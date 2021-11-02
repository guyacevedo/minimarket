package io.github.guyacevedo.minimarket.domain.repository;

import java.util.List;
import java.util.Optional;

import io.github.guyacevedo.minimarket.domain.dto.Product;


/**
 * @Title: ProductRepository.java
 * @Package io.github.guyacevedo.apimarket.domain.repository
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 31/10/2021-12:48:21 a. m.
 * @version V1.0
 */
public interface ProductRepository {

	public List<Product> getAll();

	public Optional<List<Product>> getByCategory(int categoryId);

	public Optional<List<Product>> getScarseProducts(int quantity);

	public Optional<Product> getProduct(int id);

	public Product save(Product product);

	public void delete(int id);
	
}
