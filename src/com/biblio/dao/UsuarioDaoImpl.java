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

import com.biblio.pojo.Usuario;

/**
* @author vchirinosb
* @since 22/10/2016
*/
@Transactional
@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Usuario usuario) {
		getSession().save(usuario);		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		// Usando HQL
		// Query query = getSession().createQuery("FROM Usuario"); //select * from Usuario;
		// return query.list();
		
		Criteria crit = getSession().createCriteria(Usuario.class)
				.addOrder(Order.asc("usuario"));

		return crit.list();
	}
	
	//********** Inicio Paginacion **********
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll(Integer offset, Integer maxResults) {
		Criteria crit = getSession().createCriteria(Usuario.class)
				.setFirstResult(offset!=null?offset:0)
				.setMaxResults(maxResults!=null?maxResults:10)
				.addOrder(Order.asc("usuario"));
		
		return crit.list();
	}
	
	@Override
	public Long count() {
		Criteria crit = getSession().createCriteria(Usuario.class);
	    crit.setProjection(Projections.rowCount());
		return (Long) crit.uniqueResult();
	}
	//********** Fin Paginacion **********

	@Override
	public Usuario findById(int idUsuario) {
		// Usando Criteria
		Criteria crit = getSession().createCriteria(Usuario.class);
		crit.add(Restrictions.eq("idUsuario", idUsuario));
		return (Usuario) crit.uniqueResult();
	}

	@Override
	public Usuario findByUsuario(String usuario) {
		// Usando Criteria
		Criteria crit = getSession().createCriteria(Usuario.class);
		crit.add(Restrictions.like("usuario", usuario));
		return (Usuario) crit.uniqueResult();
		
	}

	@Override
	public void update(Usuario usuario) {
		getSession().update(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		getSession().delete(usuario);
	}

}
