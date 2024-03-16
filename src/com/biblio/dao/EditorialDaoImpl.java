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

import com.biblio.pojo.Editorial;

/**
* @author vchirinosb
* @since 18/10/2016
*/
@Transactional
@Repository
public class EditorialDaoImpl implements EditorialDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Editorial editorial) {
		getSession().save(editorial);		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Editorial> findAll() {
		// Usando HQL
		// Query query = getSession().createQuery("FROM Editorial"); //select * from Editorial;
		// return query.list();
		
		Criteria crit = getSession().createCriteria(Editorial.class)
				.addOrder(Order.asc("editorial"));

		return crit.list();
	}
	
	//********** Inicio Paginacion **********
	@SuppressWarnings("unchecked")
	@Override
	public List<Editorial> findAll(Integer offset, Integer maxResults) {
		Criteria crit = getSession().createCriteria(Editorial.class)
				.setFirstResult(offset!=null?offset:0)
				.setMaxResults(maxResults!=null?maxResults:10)
				.addOrder(Order.asc("editorial"));
		
		return crit.list();
	}
	
	@Override
	public Long count() {
		Criteria crit = getSession().createCriteria(Editorial.class);
	    crit.setProjection(Projections.rowCount());
		return (Long) crit.uniqueResult();
	}
	//********** Fin Paginacion **********

	@Override
	public Editorial findById(int idEditorial) {
		// Usando Criteria
		Criteria crit = getSession().createCriteria(Editorial.class);
		crit.add(Restrictions.eq("idEditorial", idEditorial));
		return (Editorial) crit.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Editorial> findByEditorial(String editorial) {
		// Usando Criteria
		Criteria crit = getSession().createCriteria(Editorial.class);
		crit.add(Restrictions.like("editorial", "%" + editorial + "%"));
		return crit.list();
	}

	@Override
	public void update(Editorial editorial) {
		getSession().update(editorial);
	}

	@Override
	public void delete(Editorial editorial) {
		getSession().delete(editorial);
	}

}
