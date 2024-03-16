package com.biblio.dao;

import java.util.List;

import com.biblio.pojo.Autor;

/**
* @author vchirinosb
* @since 18/10/2016
*/
public interface AutorDao {

	public void save(Autor autor);
	public List<Autor> findAll();
	
	public List<Autor> findAll(Integer offset, Integer maxResults); //paginacion
	public Long count();
	
	public Autor findById(int idAutor);
	public List<Autor> findByNombre(String nombre);
	public void update(Autor autor);
	public void delete(Autor autor);

}
