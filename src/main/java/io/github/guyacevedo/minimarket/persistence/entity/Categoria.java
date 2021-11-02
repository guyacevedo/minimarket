package io.github.guyacevedo.minimarket.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

/**
 * @Title: Categoria.java
 * @Package io.github.guyacevedo.minimarket.persistence.entity
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-10:05:04 p. m.
 * @version V1.0
 */
@Data
@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer id;

	private String descripcion;

	private Boolean estado;

	@OneToMany(mappedBy = "categoria")
	private List<Producto> productos;
	
}
