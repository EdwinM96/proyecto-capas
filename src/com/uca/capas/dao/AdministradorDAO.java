package com.uca.capas.dao;

import java.util.List;
import com.uca.capas.domain.Administrador;
public interface AdministradorDAO {

	public List<Administrador> findAll();
	public List<Administrador> findAllLimit(int limite);
	public Administrador findAdmin(String username);
}
