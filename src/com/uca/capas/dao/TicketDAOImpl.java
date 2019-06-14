package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.uca.capas.domain.Ticket;

public class TicketDAOImpl implements TicketDAO {
	
	@PersistenceContext(unitName="persistencia")
	EntityManager entityManager;

	@Override
	public List<Ticket> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.ticket");
		Query query = entityManager.createNativeQuery(sb.toString(), Ticket.class);
		List<Ticket> results = query.getResultList();
		return results;
	}

	@Override
	public List<Ticket> findAllLimit(int limite) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.ticket limit ?1");
		Query query = entityManager.createNativeQuery(sb.toString(), Ticket.class);
		query.setParameter(1, limite);
		List<Ticket> results = query.getResultList();
		return results;
	}

	
}
