package io.github.guyacevedo.minimarket.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.github.guyacevedo.minimarket.persistence.entity.Usuario;



/**
 * @Title: UsuarioDAO.java
 * @Package io.github.guyacevedo.minimarket.persistence.dao
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:14:04 p. m.
 * @version V1.0
 */
@Repository("usuarioDAO")
public interface UsuarioDAO extends JpaRepository<Usuario, Long>, PagingAndSortingRepository<Usuario, Long> {

	public abstract Usuario findByEmail(String email);

	public abstract Usuario getById(Long id);

}