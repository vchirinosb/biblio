package com.biblio.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblio.dao.AutorDao;
import com.biblio.dao.EditorialDao;
import com.biblio.dao.LibroDao;
import com.biblio.pojo.Autor;
import com.biblio.pojo.Editorial;
import com.biblio.pojo.Libro;
import com.biblio.service.dto.LibroDTO;

/**
 * @author vchirinosb
 * @since 20/10/2016
 */
@Service
public class LibroService {

	@Autowired
	private AutorDao autorDao;

	@Autowired
	private EditorialDao editorialDao;

	@Autowired
	private LibroDao libroDao;

	public void save(Autor autor, Editorial editorial, Libro libro) {
		libro.setAutor(autor);
		libro.setEditorial(editorial);
		libroDao.save(libro);
	}

	public List<Libro> findAllByAutor(int idAutor) {
		Autor autor = autorDao.findById(idAutor);
		return libroDao.findAllByAutor(autor);
	}

	public List<Libro> findAllByEditorial(int idEditorial) {
		Editorial editorial = editorialDao.findById(idEditorial);
		return libroDao.findAllByEditorial(editorial);
	}

	// Paginacion ******
	public List<LibroDTO> findAll(Integer offset, Integer maxResults) {

		List<Object[]> query = libroDao.findAll(offset, maxResults);

		List<LibroDTO> lst = new ArrayList<LibroDTO>();
		if (!query.isEmpty()) {
			Iterator<Object[]> it = query.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				lst.add(new LibroDTO((int) obj[0], (String) obj[1], (String) obj[2], (String) obj[3],
						(int) obj[4], (String) obj[5], (int) obj[6]));
			}
		}

		return lst;
	}

	public Long count() {
		return libroDao.count();
	}

	public List<LibroDTO> findAll(LibroDTO libroDTO, Integer offset, Integer maxResults) {

		List<Object[]> query = libroDao.findAll(libroDTO, offset, maxResults);

		List<LibroDTO> lst = new ArrayList<LibroDTO>();
		if (!query.isEmpty()) {
			Iterator<Object[]> it = query.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				lst.add(new LibroDTO((int) obj[0], (String) obj[1], (String) obj[2], (String) obj[3],
						(int) obj[4], (String) obj[5], (int) obj[6]));
			}
		}

		return lst;
	}

	public Long count(LibroDTO libroDTO) {
		return libroDao.count(libroDTO);
	}

	// *********
	
	public Libro findById(int idLibro) {
		return libroDao.findById(idLibro);
	}

	public void saveOrUpdate(Libro libro) {
		if (libro.getIdLibro() == 0) {
			// insert
			libroDao.save(libro);
		} else {
			// update
			libroDao.update(libro);
		}
	}

	public void delete(int idLibro) {
		Libro libro = libroDao.findById(idLibro);
		libroDao.delete(libro);
	}
}
