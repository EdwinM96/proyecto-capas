package com.uca.capas.dao;

import java.util.List;

import com.uca.capas.domain.Usuario;

public interface UsuarioDAO {

	public List<Usuario> findAll();
	
	public List<Usuario> findAllLimit(int limite);
	public Usuario findUser(String username);
}
