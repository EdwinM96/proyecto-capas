package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uca.capas.dao.PeliculaDAO;
import com.uca.capas.domain.Pelicula;

public class PeliculaService {

	@Autowired
	PeliculaDAO peliculaDao;
	
	public List<Pelicula> listAll(){
		return peliculaDao.listAll();
	}
}
