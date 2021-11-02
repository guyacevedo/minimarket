package io.github.guyacevedo.minimarket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.github.guyacevedo.minimarket.persistence.service.UsuarioService;


/**
 * @Title: SecurityConfig.java
 * @Package io.github.guyacevedo.minimarket.config
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:15:12 p. m.
 * @version V1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;

	String[] resources = new String[] { "/login/**", "/include/**", "/assets/**", "/css/**", "/icons/**", "/img/**",
			"/js/**", "/vendor/**" };

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
					.antMatchers(resources).permitAll()
				// Permitimos el acceso al login a cualquiera y recursos principales
				.anyRequest().authenticated()
				// Cualquier otra peticion requiere autenticacion
				.and()// Las peticiones login pasaran previamente por este filtro
				.addFilterBefore(new LoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				// Las demas peticiones pasaran previamente por este filtro
				.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}
