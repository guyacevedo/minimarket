package io.github.guyacevedo.minimarket.config;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * @Title: User.java
 * @Package io.github.guyacevedo.minimarket.config
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:15:12 p. m.
 * @version V1.0
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Getter
	@Setter
	private String username;

	@Getter
	@Setter
	private String password;
}
