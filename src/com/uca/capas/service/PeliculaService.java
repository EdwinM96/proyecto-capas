package com.uca.capas.service;

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
		return peliculaDao.listAll();
	}
}
