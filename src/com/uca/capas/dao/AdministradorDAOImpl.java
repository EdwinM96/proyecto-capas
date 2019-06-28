package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Administrador;

@Repository
public class AdministradorDAOImpl implements AdministradorDAO {
	@PersistenceContext(unitName = "persistencia")
	private EntityManager entityManager; 
	
	@Override
	public List<Administrador> findAll() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("select * from public.administrador");
		Query query = entityManager.createNativeQuery(sb.toString(), Administrador.class);
		List<Administrador> list = (List<Administrador>)query.getResultList();
		return list;
	}

	@Override
	public List<Administrador> findAllLimit(int limite) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.administrador order by username limit ?1");
		Query query = entityManager.createNativeQuery(sb.toString(),Administrador.class);
		query.setParameter(1, limite);
		List<Administrador> list = query.getResultList();
		return list;
	}

	@Override
	public Administrador findAdmin(String username) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.administrador where username = ?1 limit 1");
		Query query = entityManager.createNativeQuery(sb.toString(),Administrador.class);
		query.setParameter(1, username);
		Administrador result = (Administrador) query.getResultList();
		return result;
	}

}
