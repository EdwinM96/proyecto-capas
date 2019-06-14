package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uca.capas.dao.AdministradorDAO;
import com.uca.capas.domain.Administrador;

public class AdministradorService {

	@Autowired
	AdministradorDAO adminDao;
	
	public List<Administrador> listAll(){
		return adminDao.findAll();
		
	}
}
