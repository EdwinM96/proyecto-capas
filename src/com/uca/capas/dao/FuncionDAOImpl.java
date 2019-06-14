package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.uca.capas.domain.Funcion;

public class FuncionDAOImpl implements FuncionDAO{
	@PersistenceContext(unitName = "persistencia")
	private EntityManager entityManager;
	
	
	@Override
	public List<Funcion> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.funcion");
		Query query = entityManager.createNativeQuery(sb.toString(), Funcion.class);
		List<Funcion> results = query.getResultList();
		return results;
	}

	@Override
	public List<Funcion> findAllLimit(int limite) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.funcion limit ?1");
		Query query = entityManager.createNativeQuery(sb.toString(),Funcion.class);
		query.setParameter(1, limite);
		List<Funcion> results = query.getResultList();
		return results;
	}

}
