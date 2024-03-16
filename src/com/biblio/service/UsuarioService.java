package com.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biblio.pojo.Usuario;
import com.biblio.dao.UsuarioDao;

/**
* @author vchirinosb
* @since 23/10/2016
*/
@Service
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void save(Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuarioDao.save(usuario);
	}

	public List<Usuario> findAll() {

		return usuarioDao.findAll();
	}

	// Paginacion ******
	public List<Usuario> findAll(Integer offset, Integer maxResults) {
		return usuarioDao.findAll(offset, maxResults);
	}
	
	public Long count(){
		  return usuarioDao.count();
	}
	// *********

	public Usuario findById(int idUsuario) {
		return usuarioDao.findById(idUsuario);
	}

	public void saveOrUpdate(Usuario usuario) {
		if (usuario.getIdUsuario() == 0) {
			// insert
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			usuarioDao.save(usuario);
		} else {
			// update
			usuarioDao.update(usuario);
		}
	}

	public void delete(int idUsuario) {
		Usuario usuario = usuarioDao.findById(idUsuario);
		usuarioDao.delete(usuario);
	}

}
