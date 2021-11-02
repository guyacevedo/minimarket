package io.github.guyacevedo.minimarket.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * @Title: Usuario.java
 * @Package io.github.guyacevedo.minimarket.persistence.entity
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:09:08 p. m.
 * @version V1.0
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 3241844245610495838L;

	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id",  unique = true)
	private long id;

	@Getter
	@Setter
	@NonNull
	@NotEmpty
	@NotNull
	@Size(min = 1, message = "Los nombres del usuario son obligatorios.")
	@Column(name = "nombres")
	private String nombres;

	@Getter
	@Setter
	@NonNull
	@NotEmpty
	@NotNull
	@Size(min = 1, message = "Los apellidos del usuario son obligatorios.")
	@Column(name = "apellidos")
	private String apellidos;

	@Getter
	@Setter
	@NonNull
	@NotEmpty
	@Email(message = "El email del usuario es invalido.")
	@Column(name = "email", unique = true)
	private String email;

	@Getter
	@Setter
	@NonNull
	@NotEmpty
	@NotNull
	@Size(min = 8, message = "La contraseña del usuario es invalida. Debe tener minimo 8 caracteres")
	@Column(name = "password")
	private String password;

	@Getter
	@Setter
	@NotNull
	@Column(name = "activo")
	private boolean activo;

	@Getter
	@Setter
	@NonNull
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(referencedColumnName= "id"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
			)
	private Set<Rol> roles = new HashSet<Rol>();
}