package com.biblio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblio.dao.EditorialDao;
import com.biblio.pojo.Editorial;

/**
 * @author vchirinosb
 * @since 18/10/2016
 */
@Service
public class EditorialService {

	@Autowired
	private EditorialDao editorialDao;

	public void save(Editorial editorial) {
		editorialDao.save(editorial);
	}

	public List<Editorial> findAll() {

		return editorialDao.findAll();
	}

	// Paginacion ******
	public List<Editorial> findAll(Integer offset, Integer maxResults) {
		return editorialDao.findAll(offset, maxResults);
	}

	public Long count() {
		return editorialDao.count();
	}
	// *********

	public Editorial findById(int idEditorial) {
		return editorialDao.findById(idEditorial);
	}

	public void saveOrUpdate(Editorial editorial) {
		if (editorial.getIdEditorial() == 0) {
			// insert
			editorialDao.save(editorial);
		} else {
			// update
			editorialDao.update(editorial);
		}
	}

	public void delete(int idEditorial) {
		Editorial editorial = editorialDao.findById(idEditorial);
		editorialDao.delete(editorial);
	}

}
