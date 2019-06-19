package com.uca.capas.dao;

import java.util.List;

import com.uca.capas.domain.Funcion;
import com.uca.capas.domain.Ticket;

public interface TicketDAO {

	public List<Ticket> findAll();
	
	public List<Ticket> findAllLimit(int limite);
	
	public int Avaliableseats(Funcion fun);
	
	public boolean Insert(Ticket ticket);
	
}
