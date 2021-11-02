package io.github.guyacevedo.minimarket.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.github.guyacevedo.minimarket.persistence.entity.Rol;
import io.github.guyacevedo.minimarket.persistence.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Title: UserDetails.java
 * @Package io.github.guyacevedo.minimarket.config
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:15:12 p. m.
 * @version V1.0
 */
@AllArgsConstructor
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Usuario user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<Rol> roles = user.getRoles();

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (Rol rol : roles) {
			authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return user.isActivo();
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return user.isActivo();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return user.isActivo();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return user.isActivo();
	}

}
