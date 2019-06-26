package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="administrador")
public class Administrador {
	
	@Id
	@Column (name="username")
	private String username;
	
	@Column (name="password")
	private String password;
	
	@Column (name="b_sesion")
	private boolean session;

	
	
	public Administrador(String username, String password, boolean session) {
		super();
		this.username = username;
		this.password = password;
		this.session = session;
	}

	public Administrador() {
		super();
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

	public boolean isSession() {
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
	}
	
	
	
			}
