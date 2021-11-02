package io.github.guyacevedo.minimarket.persistence.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.guyacevedo.minimarket.persistence.dao.RolDAO;
import io.github.guyacevedo.minimarket.persistence.dao.UsuarioDAO;
import io.github.guyacevedo.minimarket.persistence.entity.Rol;
import io.github.guyacevedo.minimarket.persistence.entity.Usuario;



/**
 * @Title: InstalacionService.java
 * @Package io.github.guyacevedo.minimarket.persistence.service
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:31:44 p. m.
 * @version V1.0
 */
@Service("instalacionService")
public class InstalacionService {

	@Autowired
	@Qualifier("usuarioDAO")
	private UsuarioDAO usuarioDAO;

	@Autowired
	@Qualifier("rolDAO")
	private RolDAO rolDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private Environment env;

	private static final Log logger = LogFactory.getLog(InstalacionService.class);

	public void init_usuarios() {
		logger.info("Verificacion de usuarios iniciales");

		try {
			logger.info("rol grupo Usuario");
			logger.info(rolDAO.findByNombre("Usuario").toString());
			logger.info("rol Usuario encontrado");
		} catch (Exception e) {
			logger.error("Error al buscar " + e);
			logger.info("Creando rol Usuario");
			rolDAO.save(new Rol(1, "Usuario"));
			logger.info("rol Usuario creado");
		}

		try {
			logger.info("rol grupo administrador");
			logger.info(rolDAO.findByNombre("Administrador").toString());
			logger.info("rol administrador encontrado");
		} catch (Exception e1) {
			logger.error("rol administrador no encontrado " + e1);
			logger.info("Creando rol administrador");
			rolDAO.save(new Rol(2, "Administrador"));
			logger.info("rol administrador creado");
		}

		try {
			logger.info("Buscando usuario inicial");
			Usuario usuario = usuarioDAO.findByEmail(env.getProperty("guyacevedo.usuario.email"));
			logger.info("Usuario encontrado \n" + usuario.toString());
		} catch (Exception e2) {
			String password = env.getProperty("guyacevedo.usuario.password");
			try {
				password = passwordEncoder.encode(env.getProperty("guyacevedo.usuario.password"));
			} catch (Exception e4) {
				logger.error("Error al Encriptar password " + e4);
			}
			try {
				logger.error("usuario no encontrado " + e2);
				logger.info("Creando usuario administrador");
				Usuario usuario = new Usuario();
				usuario.setId(1);
				usuario.setNombres(env.getProperty("guyacevedo.usuario.nombres"));
				usuario.setApellidos(env.getProperty("guyacevedo.usuario.apellidos"));
				usuario.setEmail(env.getProperty("guyacevedo.usuario.email"));
				usuario.setPassword(password);
				usuario.setActivo(true);
				Set<Rol> roles = new HashSet<>();
				roles.add(new Rol(2, "Administrador"));
				usuario.setRoles(roles);
				logger.info(usuario);
				usuarioDAO.save(usuario);
			} catch (Exception e3) {
				logger.error("Error al guardar usuario " + e3);
			}

		}

		logger.info("Verificacion compleatada...");
	}

}
