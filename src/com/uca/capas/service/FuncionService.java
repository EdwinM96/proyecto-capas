package com.uca.capas.service;

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
		return funcionDao.findAll();
	}
}
