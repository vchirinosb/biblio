package com.biblio.dao;

import java.util.List;

import com.biblio.pojo.Editorial;

/**
* @author vchirinosb
* @since 18/10/2016
*/
public interface EditorialDao {

	public void save(Editorial editorial);
	public List<Editorial> findAll();
	
	public List<Editorial> findAll(Integer offset, Integer maxResults); //paginacion
	public Long count();
	
	public Editorial findById(int idEditorial);
	public List<Editorial> findByEditorial(String editorial);
	public void update(Editorial editorial);
	public void delete(Editorial editorial);

}
