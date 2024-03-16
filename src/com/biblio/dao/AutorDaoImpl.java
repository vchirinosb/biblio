package com.biblio.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.biblio.pojo.Autor;

/**
* @author vchirinosb
* @since 18/10/2016
*/
@Transactional
@Repository
public class AutorDaoImpl implements AutorDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Autor autor) {
		getSession().save(autor);		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Autor> findAll() {
		// Usando HQL
		// Query query = getSession().createQuery("FROM Autor"); //select * from Autor;
		// return query.list();
		
		Criteria crit = getSession().createCriteria(Autor.class)
				.addOrder(Order.asc("nombre"));

		return crit.list();
	}
	
	//********** Inicio Paginacion **********
	@SuppressWarnings("unchecked")
	@Override
	public List<Autor> findAll(Integer offset, Integer maxResults) {
		Criteria crit = getSession().createCriteria(Autor.class)
				.setFirstResult(offset!=null?offset:0)
				.setMaxResults(maxResults!=null?maxResults:10)
				.addOrder(Order.asc("nombre"));
		
		return crit.list();
	}
	
	@Override
	public Long count() {
		Criteria crit = getSession().createCriteria(Autor.class);
	    crit.setProjection(Projections.rowCount());
		return (Long) crit.uniqueResult();
	}
	//********** Fin Paginacion **********

	@Override
	public Autor findById(int idAutor) {
		// Usando Criteria
		Criteria crit = getSession().createCriteria(Autor.class);
		crit.add(Restrictions.eq("idAutor", idAutor));
		return (Autor) crit.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Autor> findByNombre(String nombre) {
		// Usando Criteria
		Criteria crit = getSession().createCriteria(Autor.class);
		crit.add(Restrictions.like("nombre", "%" + nombre + "%"));
		return crit.list();
	}

	@Override
	public void update(Autor autor) {
		getSession().update(autor);
	}

	@Override
	public void delete(Autor autor) {
		getSession().delete(autor);
	}

}
