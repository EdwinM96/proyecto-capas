package com.uca.capas.dao;

import java.util.List;

import com.uca.capas.domain.Pelicula;

public interface PeliculaDAO {

	public List<Pelicula> listAll();
	public List<Pelicula> findAllLimit(int limite);
	
	public Pelicula findPelicula(String titulo);
	public List<Pelicula> findAllCurrentPeliculas();
}
