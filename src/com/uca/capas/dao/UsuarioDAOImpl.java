package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

	@PersistenceContext(unitName="persistencia")
	private EntityManager entityM;
	
	@Override
	public List<Usuario> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.usuario");
		Query query = entityM.createNativeQuery(sb.toString(),Usuario.class);
		List<Usuario> list = query.getResultList();
		return list;
	}

	@Override
	public List<Usuario> findAllLimit(int limite) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.usuario order by username limit ?1");
		
		Query query = entityM.createNativeQuery(sb.toString(), Usuario.class);
		query.setParameter(1, limite);
		
		List<Usuario> list = query.getResultList();
		return list;
	}
	
	@Override
	public Usuario findUser(String username) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.usuario where username = ?1 limit 1");
		
		Query query = entityM.createNativeQuery(sb.toString(),Usuario.class);
		query.setParameter(1, username);
		
		Usuario usuario = (Usuario) query.getSingleResult();
		return usuario;
	}

	@Override
	public void changeLoginFlag(String username, Boolean flag) {
		StringBuffer sb = new StringBuffer();
		sb.append("update public.usuario set b_sesion = ?1 where username=?2");
		
		Query query = entityM.createNativeQuery(sb.toString());
		query.setParameter(1, flag);
		query.setParameter(2, username);
		
		query.executeUpdate();
		
	}
}
