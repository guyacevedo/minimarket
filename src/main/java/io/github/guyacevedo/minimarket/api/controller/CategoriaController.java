package io.github.guyacevedo.minimarket.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.guyacevedo.minimarket.domain.dto.Category;
import io.github.guyacevedo.minimarket.persistence.service.CategoriaService;



/**
 * @Title: CategoriaController.java
 * @Package io.github.guyacevedo.minimarket.api.controller
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-10:35:45 p. m.
 * @version V1.0
 */

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	@Qualifier("categoriaService")
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<Category>> listarcategories() {
		List<Category> categories = categoriaService.getAll();
		if (categories != null) {
			return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
