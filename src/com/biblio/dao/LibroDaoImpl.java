package com.biblio.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.biblio.pojo.Autor;
import com.biblio.pojo.Editorial;
import com.biblio.pojo.Libro;
import com.biblio.service.dto.LibroDTO;

@Transactional
@Repository
public class LibroDaoImpl implements LibroDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Libro libro) {
		getSession().save(libro);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Libro> findAllByAutor(Autor autor) {
		// Usando Criteria
		Criteria crit = getSession().createCriteria(Libro.class).setFetchMode("autor", FetchMode.JOIN)
				.add(Restrictions.eq("autor.idAutor", autor.getIdAutor()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).addOrder(Order.asc("titulo"));

		return crit.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Libro> findAllByEditorial(Editorial editorial) {
		// Usando Criteria
		Criteria crit = getSession().createCriteria(Libro.class).setFetchMode("editorial", FetchMode.JOIN)
				.add(Restrictions.eq("editorial.idEditorial", editorial.getIdEditorial()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).addOrder(Order.asc("titulo"));

		return crit.list();
	}

	@Override
	public Libro findById(int idLibro) {
		// Usando Criteria
		Criteria crit = getSession().createCriteria(Libro.class);
		crit.add(Restrictions.eq("idLibro", idLibro));
		return (Libro) crit.uniqueResult();
	}

	// ********** Inicio Paginacion **********
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findAll(Integer offset, Integer maxResults) {
		// Usando HQL
		String hql = "SELECT l.idLibro, l.titulo, "
				+ "a.nombre, "
				+ "e.editorial, "
				+ "l.anhoPublicacion, l.edicion, l.cantidadEjemplares "
				+ "FROM Libro AS l "
				+ "INNER JOIN l.autor AS a " + "INNER JOIN l.editorial AS e "
				+ "ORDER BY l.titulo, a.nombre, e.editorial";

		Query query = getSession().createQuery(hql).setFirstResult(offset != null ? offset : 0)
				.setMaxResults(maxResults != null ? maxResults : 10);
		return (List<Object[]>) query.list();
	}

	@Override
	public Long count() {
		String hql = "SELECT count(*) "
				+ "FROM Libro as l "
				+ "INNER JOIN l.autor as a "
				+ "INNER JOIN l.editorial as e";

		Query query = getSession().createQuery(hql);
		return (Long) query.list().get(0);
	}
	// ********** Fin Paginacion **********

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findAll(LibroDTO libroDTO, Integer offset, Integer maxResults) {

		// Usando HQL
		String hql = "SELECT l.idLibro, l.titulo, "
				+ "a.nombre, "
				+ "e.editorial, "
				+ "l.anhoPublicacion, l.edicion, l.cantidadEjemplares "
				+ "FROM Libro AS l "
				+ "INNER JOIN l.autor AS a " + "INNER JOIN l.editorial AS e "
				+ "WHERE upper(a.nombre) LIKE '%"
				+ libroDTO.getAutor().toUpperCase() + "%' "
				+ "AND upper(e.editorial) LIKE '%"
				+ libroDTO.getEditorial().toUpperCase() + "%' "
				+ "GROUP BY l.idLibro, l.titulo, a.nombre, e.editorial "
				+ "ORDER BY l.titulo, a.nombre, e.editorial";

		Query query = getSession().createQuery(hql).setFirstResult(offset != null ? offset : 0)
				.setMaxResults(maxResults != null ? maxResults : 10);
		return (List<Object[]>) query.list();
	}

	@Override
	public Long count(LibroDTO libroDTO) {

		// Usando HQL
		String hql = "SELECT count(*) " + "FROM Libro as l "
					+ "INNER JOIN l.autor as a "
					+ "INNER JOIN l.editorial as e "
					+ "WHERE upper(a.nombre) LIKE '%"
					+ libroDTO.getAutor().toUpperCase() + "%' "
					+ "AND upper(e.editorial) LIKE '%"
					+ libroDTO.getEditorial().toUpperCase() + "%'";

		Query query = getSession().createQuery(hql);
		return (Long) query.list().get(0);
	}

	@Override
	public void update(Libro libro) {
		getSession().update(libro);
	}

	@Override
	public void delete(Libro libro) {
		getSession().delete(libro);
	}

}
