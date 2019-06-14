package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.uca.capas.domain.Administrador;

public class AdministradorDAOImpl implements AdministradorDAO {
	@PersistenceContext(unitName = "persistencia")
	private EntityManager entityManager; 
	
	@Override
	public List<Administrador> findAll() {
		StringBuffer sb = new StringBuffer();
		//Defino la consulta
		sb.append("select * from public.administrador");
		//Creo un objeto Query a partir del entityManager para ejecutar la consulta
		Query query = entityManager.createNativeQuery(sb.toString(), Administrador.class);
		//Ejecuto la consulta y establezco el resultado a una coleccion de Clientes
		List<Administrador> list = query.getResultList();
		
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
