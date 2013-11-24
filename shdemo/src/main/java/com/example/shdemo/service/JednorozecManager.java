package com.example.shdemo.service;



import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Jednorozec;
import com.example.shdemo.domain.Person;

@Component
@Transactional
public class JednorozecManager implements JednorozecManagerIn{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addJednorozec(Jednorozec jednorozec) {
		jednorozec.setId(null);
		sessionFactory.getCurrentSession().persist(jednorozec);
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Jednorozec> getAllJednorozce() {
		return sessionFactory.getCurrentSession().getNamedQuery("jednorozec.getAll").list();
	}

	@Override
	public void deleteJednorozec(Jednorozec jednorozec) {
		jednorozec = (Jednorozec) sessionFactory.getCurrentSession().get(Jednorozec.class, jednorozec.getId());
		sessionFactory.getCurrentSession().delete(jednorozec);
		
	}

	@Override
	public Jednorozec getJednorozecById(long id) {
		return (Jednorozec) sessionFactory.getCurrentSession().getNamedQuery("jednorozec.byId").setLong("id", id).uniqueResult();
	}

}
