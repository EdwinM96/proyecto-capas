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
@Table(schema="public", name="usuario")
public class Usuario {
	
	
	 	@Id
	 	@GeneratedValue(generator="usuario_id_usuario_seq", strategy = GenerationType.AUTO)
		@SequenceGenerator(name = "usuario_id_usuario_seq", sequenceName = "public.usuario_id_usuario_seq")
	    @Column(name="id_usuario")
	    private Integer idUsuario;
	    
	 	@Column(name="saldo")
	 	private Float saldo;
	 	
	 	@Column(name="b_sesion")
	 	private Boolean session;
	 	
	 	@Column(name="estado")
	 	private Boolean estado;
	 	
	 	@Temporal(TemporalType.DATE)
		@DateTimeFormat(iso = ISO.DATE)
	 	@Column(name="f_modificacion")
	 	private Calendar f_modificacion;
	 	
	 	@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "a_creacion")
	 	private Administrador a_creacion;
	 	
	 	@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "a_modificacion")
	 	private Administrador a_modificacion;
	 	
	 	@Column(name="edad")
	 	private Integer edad;
	 	
	 	@Column(name="municipio")
	 	private String municipio;
	 	
	 	@Column(name="departamento")
	 	private String departamento;
	 	
	 	@Column(name="descripcion")
	 	private String descripcion;
	 	
	 	@Temporal(TemporalType.DATE)
		@DateTimeFormat(iso = ISO.DATE)
	 	@Column(name="f_creacion")
	 	private Calendar f_creacion;
	 	
	    @Column(name="username")
		private String username;
	    
	    @Column(name="password")
	    private String password;
	    
	    public Usuario() {
	    }
	    
	    
	    public Usuario(Integer idUsuario, float saldo, boolean session, boolean estado, Calendar f_modificacion,
				Administrador a_creacion, Administrador a_modificacion, int edad, String municipio, String departamento,
				String descripcion, Calendar f_creacion, String username, String password) {
			super();
			this.idUsuario = idUsuario;
			this.saldo = saldo;
			this.session = session;
			this.estado = estado;
			this.f_modificacion = f_modificacion;
			this.a_creacion = a_creacion;
			this.a_modificacion = a_modificacion;
			this.edad = edad;
			this.municipio = municipio;
			this.departamento = departamento;
			this.descripcion = descripcion;
			this.f_creacion = f_creacion;
			this.username = username;
			this.password = password;
		}


		public Integer getIdUsuario() {
			return idUsuario;
		}


		public void setIdUsuario(Integer idUsuario) {
			this.idUsuario = idUsuario;
		}


		public Float getSaldo() {
			return saldo;
		}


		public void setSaldo(Float saldo) {
			this.saldo = saldo;
		}


		public Boolean getSession() {
			return session;
		}


		public void setSession(Boolean session) {
			this.session = session;
		}


		public Boolean getEstado() {
			return estado;
		}


		public void setEstado(Boolean estado) {
			this.estado = estado;
		}


		public Calendar getF_modificacion() {
			return f_modificacion;
		}


		public void setF_modificacion(Calendar f_modificacion) {
			this.f_modificacion = f_modificacion;
		}


		public Administrador getA_creacion() {
			return a_creacion;
		}


		public void setA_creacion(Administrador a_creacion) {
			this.a_creacion = a_creacion;
		}


		public Administrador getA_modificacion() {
			return a_modificacion;
		}


		public void setA_modificacion(Administrador a_modificacion) {
			this.a_modificacion = a_modificacion;
		}


		public Integer getEdad() {
			return edad;
		}


		public void setEdad(Integer edad) {
			this.edad = edad;
		}


		public String getMunicipio() {
			return municipio;
		}


		public void setMunicipio(String municipio) {
			this.municipio = municipio;
		}


		public String getDepartamento() {
			return departamento;
		}


		public void setDepartamento(String departamento) {
			this.departamento = departamento;
		}


		public String getDescripcion() {
			return descripcion;
		}


		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}


		public Calendar getF_creacion() {
			return f_creacion;
		}


		public void setF_creacion(Calendar f_creacion) {
			this.f_creacion = f_creacion;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		
	    
}
