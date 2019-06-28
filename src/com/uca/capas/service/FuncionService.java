package com.uca.capas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.FuncionDAO;
import com.uca.capas.domain.Funcion;

@Service
public class FuncionService {

	@Autowired
	FuncionDAO funcionDao;
	
	public List<Funcion> listAll(){
		List<Funcion> funciones = funcionDao.findAll();
		List<Funcion> funcionesDisponibles = new ArrayList<Funcion>();
		for(Funcion funcion:funciones) {
			if(funcion.getEstado()) {
				funciones.add(funcion);
			}
		}
		return funcionesDisponibles;
	}
	
	public List<Funcion> findFuncionesPelicula(Integer idPelicula){
		return funcionDao.findFuncionPelicula(idPelicula);
	}
	
	public List<Funcion> CurrentsFunctions(){
		return funcionDao.findAllCurrentFunction();
	}
}
