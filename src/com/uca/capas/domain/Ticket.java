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
	@GeneratedValue(generator="ticket_id_ticket_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "ticket_id_ticket_seq", sequenceName = "public.ticket_id_ticket_seq")
	@Column (name="id_ticket")
	private Integer idTicket;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="funcion")
	private Funcion funcion;
	
	@Column(name="num_asientos")
	private Integer numAsientos;
	
	@GeneratedValue(generator="ticket_num_trans_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "ticket_num_trans_seq", sequenceName = "public.ticket_num_trans_seq")
	@Column(name="num_trans")
	private Integer numTrans;
	
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn (name="usuario")
	private Usuario usuario;
	
	@Column(name="f_creacion")
	private Calendar fCreacion;

	
	public Ticket() {
		super();
	}

	public Integer getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Integer getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(Integer numAsientos) {
		this.numAsientos = numAsientos;
	}

	public Integer getNumTrans() {
		return numTrans;
	}

	public void setNumTrans(Integer numTrans) {
		this.numTrans = numTrans;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Calendar getfCreacion() {
		return fCreacion;
	}

	public void setfCreacion(Calendar fCreacion) {
		this.fCreacion = fCreacion;
	}
	
	
	
}
