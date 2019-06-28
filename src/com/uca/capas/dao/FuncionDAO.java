package com.uca.capas.dao;

import java.util.List;

import com.uca.capas.domain.Funcion;

public interface FuncionDAO {

	public List<Funcion> findAll();
	public List<Funcion> findAllLimit(int limite);
	public List<Funcion> findAllCurrentFunction();
	public List<Funcion> findFuncionPelicula(Integer idPelicula);

}
