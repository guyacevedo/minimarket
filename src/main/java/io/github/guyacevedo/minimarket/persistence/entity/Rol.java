package io.github.guyacevedo.minimarket.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * @Title: Rol.java
 * @Package io.github.guyacevedo.minimarket.persistence.entity
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:12:27 p. m.
 * @version V1.0
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
@Entity
public class Rol implements Serializable{

	private static final long serialVersionUID = -5655988930357657412L;

	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id",  unique = true)
	private long id;

	@Getter
	@Setter
	@NonNull
	@Column(name = "nombre", unique = true)
	private String nombre;

}