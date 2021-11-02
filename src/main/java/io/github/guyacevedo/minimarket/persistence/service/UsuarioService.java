package io.github.guyacevedo.minimarket.persistence.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.guyacevedo.minimarket.domain.dto.UsuarioDTO;
import io.github.guyacevedo.minimarket.persistence.converter.UsuarioConverter;
import io.github.guyacevedo.minimarket.persistence.dao.RolDAO;
import io.github.guyacevedo.minimarket.persistence.dao.UsuarioDAO;
import io.github.guyacevedo.minimarket.persistence.entity.Rol;
import io.github.guyacevedo.minimarket.persistence.entity.Usuario;


/**
 * @Title: UsuarioService.java
 * @Package io.github.guyacevedo.minimarket.persistence.service
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:21:25 p. m.
 * @version V1.0
 */
@Service("usuarioService")
public class UsuarioService implements UserDetailsService {

	@Autowired
	@Qualifier("usuarioDAO")
	private UsuarioDAO usuarioDAO;

	@Autowired
	@Qualifier("rolDAO")
	private RolDAO rolDAO;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private static final Log logger = LogFactory.getLog(UsuarioService.class);

	public UsuarioDTO crear(Usuario usuario) {
		logger.info("Creando usuario...");
		try {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			UsuarioDTO usuarioNuevo = null;
			logger.info("Usuario \n" + usuario.toString());
	
			if (usuario.getRoles().size()>0) {
				
				for(Rol rol: usuario.getRoles()) {
					logger.info("id rol: "+rol.getId());
				Rol rolC = rolDAO.getById(rol.getId());
						logger.info("rol: "+rolC.toString());
				}
				Usuario usuarioGuardado = usuarioDAO.save(usuario);
				logger.info("Usuario Guardado\n" + usuarioGuardado.toString());
				usuarioNuevo = new UsuarioDTO(usuarioGuardado);
				logger.info("Usuario convertido\n" + usuarioNuevo.toString());
			}
			return usuarioNuevo;
		} catch (Exception e) {
			logger.error("Hubo un error al crear el usuario\n" + e);
			return null;
		}
	}

	public UsuarioDTO actualizar(Usuario usuario) {
		logger.info("Actualizando usuario...");
		try {
			UsuarioDTO usuarioEditado = null;
			if (!usuario.getRoles().isEmpty() && usuario.getId() > 0) {
				usuarioEditado = new UsuarioDTO(usuarioDAO.save(usuario));
				logger.info("Usuario actualizado\n" + usuarioEditado.toString());
			}
			return usuarioEditado;
		} catch (Exception e) {
			logger.error("Hubo un error al actualizar el usuario\n" + e);
			return null;
		}
	}

	public UsuarioDTO borrar(Long id) {
		logger.info("Eliminando usuario...");
		try {
			Usuario usuario = usuarioDAO.getById(id);
			UsuarioDTO usuarioEliminado = new UsuarioDTO(usuario);
			usuarioDAO.delete(usuario);
			logger.info("Usuario elimnado\n" + usuarioEliminado.toString());
			return usuarioEliminado;
		} catch (Exception e) {
			logger.error("Hubo un error al eliminar el usuario\n" + e);
			return null;
		}
	}

	public List<UsuarioDTO> obtener() {
		logger.info("Obteniendo todos los usuarios...");
		try {
			return usuarioConverter.convertirLista(usuarioDAO.findAll());
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Error Obtener usuarios... \n" + e);
			return null;
		}

	}

	public UsuarioDTO obtenerPorId(long id) {
		logger.info("Buscando usuario...");
		try {
			Usuario usuarioEntity = usuarioDAO.getById(id);
			logger.info("Usuario encontrado\n" + usuarioEntity.toString());
			UsuarioDTO usuario = new UsuarioDTO(usuarioEntity);
			logger.info("Usuario convertido\n" + usuario.toString());
			return usuario;
		} catch (Exception e) {
			logger.error("Hubo un error al encontrar el usuario\n" + e);
			return null;
		}

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDAO.findByEmail(username);
		logger.info("Iniciando Sesión...");
		if (usuario == null) {
			throw new UsernameNotFoundException("No se pudo encontrar el usuario");
		}

		return new io.github.guyacevedo.minimarket.config.UserDetails(usuario);
	}

}