package io.github.guyacevedo.minimarket.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.guyacevedo.minimarket.persistence.entity.Rol;


/**
 * @Title: RolDAO.java
 * @Package io.github.guyacevedo.minimarket.persistence.dao
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:15:12 p. m.
 * @version V1.0
 */
@Repository("rolDAO")
public interface RolDAO extends JpaRepository<Rol, Long>{

	public abstract Rol findByNombre(String nombre);

	public abstract Rol getById(long id);
}
