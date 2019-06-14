package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uca.capas.dao.TicketDAO;
import com.uca.capas.domain.Ticket;

public class TicketService {

	@Autowired
	TicketDAO ticketDao;
	
	public List<Ticket> listAll(){
		return ticketDao.findAll();
	}
}
