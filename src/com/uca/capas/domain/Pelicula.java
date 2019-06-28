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
@Table (schema="public" ,name="pelicula")
public class Pelicula {

	@Id
 	@GeneratedValue(generator="pelicula_id_pelicula_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "pelicula_id_pelicula_seq", sequenceName = "public.pelicula_id_pelicula_seq")
    @Column(name="id_pelicula")
    private Integer idPelicula;
	
	@Column(name="sinopsis")
	private String sinopsis;
	
	@Column(name="imagen")
	private String imagen;
	
	@Column(name="duracion")
	private String duracion;
	
	@Column(name="estado")
	private Boolean estado;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="f_creacion")
	private Calendar fCreacion;
	
	@Column(name="titulo")
	private String titulo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="a_modificacion")
	private Administrador aModificacion;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="f_modificacion")
	private Calendar fModificacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="a_creacion")
	private Administrador aCreacion;

	public Pelicula(Integer idUsuario, String sinopsis, String imagen, String duracion, Boolean estado,
			Calendar fCreacion, String titulo, Administrador aModificacion, Calendar fModificacion,
			Administrador aCreacion) {
		super();
		this.idPelicula = idUsuario;
		this.sinopsis = sinopsis;
		this.imagen = imagen;
		this.duracion = duracion;
		this.estado = estado;
		this.fCreacion = fCreacion;
		this.titulo = titulo;
		this.aModificacion = aModificacion;
		this.fModificacion = fModificacion;
		this.aCreacion = aCreacion;
	}

	public Pelicula() {
		super();
	}

	public Integer getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Integer idUsuario) {
		this.idPelicula = idUsuario;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Calendar getfCreacion() {
		return fCreacion;
	}

	public void setfCreacion(Calendar fCreacion) {
		this.fCreacion = fCreacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Administrador getaModificacion() {
		return aModificacion;
	}

	public void setaModificacion(Administrador aModificacion) {
		this.aModificacion = aModificacion;
	}

	public Calendar getfModificacion() {
		return fModificacion;
	}

	public void setfModificacion(Calendar fModificacion) {
		this.fModificacion = fModificacion;
	}

	public Administrador getaCreacion() {
		return aCreacion;
	}

	public void setaCreacion(Administrador aCreacion) {
		this.aCreacion = aCreacion;
	}
	
	
	
	
}
