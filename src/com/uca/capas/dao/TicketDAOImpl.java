package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Funcion;
import com.uca.capas.domain.Ticket;

@Repository
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

	@Override
	public boolean Insert(Ticket ticket) {
			entityManager.persist(ticket);
			return true;		
	}


	@Override
	public int Avaliableseats(Funcion fun) {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		sb.append("select c.asientos -  c.asientosusados as asentos_disponibles from ( \r\n" + 
				"select b.asientos_disp as asientos ,sum(num_asientos) asientosusados from ticket a\r\n" + 
				"left outer join funcion b on a.funcion = b.id_funcion\r\n" + 
				"where a.funcion  = 1? group by b.asientos_disp) as c");
		Query query = entityManager.createNativeQuery(sb.toString(),int.class);
		
		query.setParameter(1,fun.getIdFuncion());
		
		int resultado = 0;
		resultado = Integer.parseInt( query.getResultList().toString());
		
		return resultado;
	}

	
}
