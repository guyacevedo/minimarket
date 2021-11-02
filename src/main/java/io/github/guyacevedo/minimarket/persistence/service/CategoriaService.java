package io.github.guyacevedo.minimarket.persistence.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.github.guyacevedo.minimarket.domain.dto.Category;
import io.github.guyacevedo.minimarket.domain.repository.CategoryRepository;
import io.github.guyacevedo.minimarket.persistence.converter.CategoriaConverter;
import io.github.guyacevedo.minimarket.persistence.dao.CategoriaDAO;

/**
 * @Title: CategoriaRepository.java
 * @Package io.github.guyacevedo.minimarket.persistence
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-10:30:52 p. m.
 * @version V1.0
 */
@Service("categoriaService")
public class CategoriaService implements CategoryRepository {
	
	@Autowired
	@Qualifier("categoriaDAO")
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	@Qualifier("categoriaConverter")
	private CategoriaConverter categoriaConverter;
	
	private static final Log logger = LogFactory.getLog(CategoriaService.class);

	@Override
	public List<Category> getAll() {
		logger.info("Obteniendo todas las categorias...");
		try {
			return categoriaConverter.convertirLista(categoriaDAO.findAll());
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Error Obtener categorias... \n" + e);
			return null;
		}
	}

	@Override
	public Optional<Category> getCategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category save(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
