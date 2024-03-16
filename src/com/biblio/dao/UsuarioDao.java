package com.biblio.dao;

import java.util.List;

import com.biblio.pojo.Usuario;

/**
* @author vchirinosb
* @since 22/10/2016
*/
public interface UsuarioDao {

	public void save(Usuario usuario);
	public List<Usuario> findAll();
	
	public List<Usuario> findAll(Integer offset, Integer maxResults); //paginacion
	public Long count();
	
	public Usuario findById(int idUsuario);
	public Usuario findByUsuario(String usuario);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);

}
