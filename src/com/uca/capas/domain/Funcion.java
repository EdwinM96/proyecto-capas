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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table (schema="public",name="funcion")
public class Funcion {

	@Id
	@GeneratedValue(generator="funcion_id_funcion_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "funcion_id_funcion_seq", sequenceName = "public.funcion_id_funcion_seq")
	@Column(name="id_funcion")
	private Integer idFuncion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pelicula")
	private Pelicula pelicula;
	
	@Column (name="hora")
	private String hora;
	
	@Column (name="sala")
	private String sala;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column (name="f_creacion")
	private Calendar fCreacion;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column (name="f_modificacion")
	private Calendar fModificacion;
	
	@Column (name="asientos_disp")
	private Integer asientosDisp;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="a_modificacion")
	private Administrador aModificacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="a_creacion")
	private Administrador aCreacion;

	
	
	public Funcion() {
		super();
	}

	public Integer getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(Integer idFuncion) {
		this.idFuncion = idFuncion;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Calendar getfCreacion() {
		return fCreacion;
	}

	public void setfCreacion(Calendar fCreacion) {
		this.fCreacion = fCreacion;
	}

	public Calendar getfModificacion() {
		return fModificacion;
	}

	public void setfModificacion(Calendar fModificacion) {
		this.fModificacion = fModificacion;
	}

	public Integer getAsientosDisp() {
		return asientosDisp;
	}

	public void setAsientosDisp(Integer asientosDisp) {
		this.asientosDisp = asientosDisp;
	}

	public Administrador getaModificacion() {
		return aModificacion;
	}

	public void setaModificacion(Administrador aModificacion) {
		this.aModificacion = aModificacion;
	}

	public Administrador getaCreacion() {
		return aCreacion;
	}

	public void setaCreacion(Administrador aCreacion) {
		this.aCreacion = aCreacion;
	}
	
	
	
	
}
