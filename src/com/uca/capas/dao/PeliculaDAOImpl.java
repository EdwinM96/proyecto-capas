package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Pelicula;

@Repository
public class PeliculaDAOImpl implements PeliculaDAO{
	@PersistenceContext(unitName = "persistencia")
	private EntityManager entityManager;
	
	
	@Override
	public List<Pelicula> listAll() {
				StringBuffer sb = new StringBuffer();
				sb.append("select * from public.pelicula");
				Query query = entityManager.createNativeQuery(sb.toString(), Pelicula.class);
				List<Pelicula> res = query.getResultList();
				
				return res;
	}

	@Override
	public List<Pelicula> findAllLimit(int limite) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.pelicula order by titulo limit ?1");
		Query query = entityManager.createNativeQuery(sb.toString(),Pelicula.class);
		query.setParameter(1, limite);
		List<Pelicula> list = query.getResultList();
		return list;
	}

	@Override
	public Pelicula findPelicula(String titulo) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.pelicula where titulo = ?1");
		Query query = entityManager.createNativeQuery(sb.toString(), Pelicula.class);
		query.setParameter(1, titulo);
		Pelicula resultado = (Pelicula) query.getResultList();
		return resultado;
	}

}
