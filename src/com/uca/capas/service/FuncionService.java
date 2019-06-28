package com.uca.capas.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.FuncionDAO;
import com.uca.capas.domain.Funcion;

@Service
public class FuncionService {

	@Autowired
	FuncionDAO funcionDao;
	
	@Autowired
	private EntityManager entityManager;
	
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
	
	@Transactional
	public Boolean editarFuncion(Funcion funcion) {
		entityManager.merge(funcion);
		entityManager.flush();
		return true;
	}
	
	public List<Funcion> findFuncionesPelicula(Integer idPelicula){
		return funcionDao.findFuncionPelicula(idPelicula);
	}
	
	public List<Funcion> CurrentsFunctions(){
		return funcionDao.findAllCurrentFunction();
	}
}
