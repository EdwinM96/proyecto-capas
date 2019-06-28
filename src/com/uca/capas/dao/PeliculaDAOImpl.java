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
	@Override
	public List<Pelicula> findAllCurrentPeliculas() {
		StringBuffer sb = new StringBuffer();
		sb.append("\r\n" + 
				"select * from pelicula where id_pelicula in (\r\n" + 
				"select distinct b.id_pelicula from funcion a\r\n" + 
				"left outer join pelicula b on a.pelicula = b.id_pelicula\r\n" + 
				"where a.fecha = current_date)");
		Query query = entityManager.createNativeQuery(sb.toString(), Pelicula.class);
		List<Pelicula> resultado = query.getResultList();
		// TODO Auto-generated method stub
		return resultado;

}
