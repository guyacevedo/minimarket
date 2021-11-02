package io.github.guyacevedo.minimarket.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.github.guyacevedo.minimarket.persistence.entity.Producto;

/**
 * @Title: ProductoDAO.java
 * @Package io.github.guyacevedo.minimarket.persistence.dao
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-10:10:47 p. m.
 * @version V1.0
 */
@Repository("productoDAO")
public interface ProductoDAO extends JpaRepository<Producto, Integer>, PagingAndSortingRepository<Producto, Integer> {

}
