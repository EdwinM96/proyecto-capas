package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="administrador")
public class Administrador {
	
	/*@Id
	@GeneratedValue(generator="administrador_id_admin_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "administrador_id_admin_seq", sequenceName = "public.administrador_id_admin_seq")
	@Column (name="id_admin")
	private Integer idAdministrador;*/
	
	@Id
	@Column (name="username")
	private String username;
	
	@Column (name="password")
	private String password;
	
	@Column (name="b_sesion")
	private Boolean session;

	
	
	
	/*public Administrador(Integer idAdministrador, String username, String password, Boolean session) {
		super();
		this.idAdministrador = idAdministrador;
		this.username = username;
		this.password = password;
		this.session = session;
	}*/
	
	public Administrador(String username, String password, Boolean session) {
		super();
		this.username = username;
		this.password = password;
		this.session = session;
	}
	
	public Administrador() {
		super();
	}

	
	/*public Integer getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Integer idAdministrador) {
		this.idAdministrador = idAdministrador;
	}*/

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

	public Boolean getSession() {
		return session;
	}

	public void setSession(Boolean session) {
		this.session = session;
	}
	
	
	
			}
