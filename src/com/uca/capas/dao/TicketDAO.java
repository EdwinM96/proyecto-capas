package com.uca.capas.dao;

import java.util.List;

import com.uca.capas.domain.Ticket;

public interface TicketDAO {

	public List<Ticket> findAll();
	
	public List<Ticket> findAllLimit(int limite);
	
}
