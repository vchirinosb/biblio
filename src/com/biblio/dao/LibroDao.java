package com.biblio.dao;

import java.util.List;

import com.biblio.pojo.Autor;
import com.biblio.pojo.Editorial;
import com.biblio.pojo.Libro;
import com.biblio.service.dto.LibroDTO;

public interface LibroDao {

	public void save(Libro libro);

	public List<Libro> findAllByAutor(Autor autor);

	public List<Libro> findAllByEditorial(Editorial editorial);

	public Libro findById(int idLibro);
	
	public List<Object[]> findAll(Integer offset, Integer maxResults); //paginacion
	public Long count();
	public List<Object[]> findAll(LibroDTO libroDTO, Integer offset, Integer maxResults);
	public Long count(LibroDTO libroDTO);

	public void update(Libro libro);

	public void delete(Libro libro);

}
