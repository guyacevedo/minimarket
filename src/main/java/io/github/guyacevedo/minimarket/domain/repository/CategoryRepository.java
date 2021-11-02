package io.github.guyacevedo.minimarket.domain.repository;

import java.util.List;
import java.util.Optional;

import io.github.guyacevedo.minimarket.domain.dto.Category;

/**
 * @Title: CategoryRepository.java
 * @Package io.github.guyacevedo.minimarket.domain.repository
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-10:23:00 p. m.
 * @version V1.0
 */
public interface CategoryRepository {
	
	public List<Category> getAll();

	public Optional<Category> getCategory(int id);

	public Category save(Category category);

	public void delete(int id);
	
}
