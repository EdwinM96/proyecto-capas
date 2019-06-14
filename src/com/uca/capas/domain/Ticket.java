package com.uca.capas.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="ticket")
public class Ticket {

	@Id
	@GeneratedValue(generator="ticket_c_ticket_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "ticket_c_ticket_seq", sequenceName = "store.ticket_c_ticket_seq")
	@Column (name="id_ticket")
	private Integer idTicket;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="funcion")
	private Funcion funcion;
	
	@Column(name="num_asientos")
	private Integer numAsientos;
	
	@GeneratedValue(generator="ticket_num_trans_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "ticket_num_trans_seq", sequenceName = "store.ticket_num_trans_seq")
	@Column(name="num_trans")
	private Integer numTrans;
	
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn (name="usuario")
	private Usuario usuario;
	
	@Column(name="f_creacion")
	private Calendar fCreacion;
	
	
}
