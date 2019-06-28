package com.uca.capas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.PeliculaDAO;
import com.uca.capas.domain.Pelicula;

@Service
public class PeliculaService {

	@Autowired
	PeliculaDAO peliculaDao;
	
	public List<Pelicula> listAll(){
		List<Pelicula> peliculas =  peliculaDao.listAll();
		List<Pelicula> peliculasDisponibles = new ArrayList<Pelicula>();
		for(Pelicula pelicula: peliculas) {
			if(pelicula.getEstado()) {
				peliculasDisponibles.add(pelicula);
			}
		}
		return peliculasDisponibles;
	}
}
