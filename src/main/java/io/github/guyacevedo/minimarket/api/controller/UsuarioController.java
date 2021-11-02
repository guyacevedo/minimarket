package io.github.guyacevedo.minimarket.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.guyacevedo.minimarket.domain.dto.UsuarioDTO;
import io.github.guyacevedo.minimarket.persistence.entity.Usuario;
import io.github.guyacevedo.minimarket.persistence.service.UsuarioService;



/**
 * @Title: UsuarioController.java
 * @Package io.github.guyacevedo.minimarket.api.controller
 * @Descripción: ${TODO} (Describa qué se describe este archivo en una oración)
 * @author guyacevedo  E-mail: guy.acevedoa@gmail.com
 * @date 1/11/2021-9:35:35 p. m.
 * @version V1.0
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
		List<UsuarioDTO> usuarios = usuarioService.obtener();
		if (usuarios != null) {
			return new ResponseEntity<List<UsuarioDTO>>(usuarios, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Secured("Administrador")
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable("id") long id) {
		UsuarioDTO usuario = usuarioService.obtenerPorId(id);
		if (usuario != null) {
			return new ResponseEntity<UsuarioDTO>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody @Validated @Valid Usuario usuario,
			BindingResult erros) {

		if (erros.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		UsuarioDTO usuarioNuevo = usuarioService.crear(usuario);
		if (usuarioNuevo != null) {
			return new ResponseEntity<UsuarioDTO>(usuarioNuevo, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody @Validated @Valid Usuario usuario,
			BindingResult erros) {
		if (erros.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		UsuarioDTO usuarioActualizado = usuarioService.actualizar(usuario);
		if (usuarioActualizado != null) {
			return new ResponseEntity<UsuarioDTO>(usuarioActualizado, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioDTO> eliminarUsuario(@PathVariable("id") long id) {
		UsuarioDTO usuario = usuarioService.borrar(id);
		if (usuario != null) {
			return new ResponseEntity<UsuarioDTO>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}