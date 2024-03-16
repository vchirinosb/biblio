package com.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblio.dao.AutorDao;
import com.biblio.pojo.Autor;

/**
* @author vchirinosb
* @since 18/10/2016
*/
@Service
public class AutorService {

	@Autowired
	private AutorDao autorDao;

	public void save(Autor autor) {
		autorDao.save(autor);
	}

	public List<Autor> findAll() {

		return autorDao.findAll();
	}

	// Paginacion ******
	public List<Autor> findAll(Integer offset, Integer maxResults) {
		return autorDao.findAll(offset, maxResults);
	}
	
	public Long count(){
		  return autorDao.count();
	}
	// *********

	public Autor findById(int idCliente) {
		return autorDao.findById(idCliente);
	}

	public void saveOrUpdate(Autor autor) {
		if (autor.getIdAutor() == 0) {
			// insert
			autorDao.save(autor);
		} else {
			// update
			autorDao.update(autor);
		}
	}

	public void delete(int idAutor) {
		Autor autor = autorDao.findById(idAutor);
		autorDao.delete(autor);
	}

}
