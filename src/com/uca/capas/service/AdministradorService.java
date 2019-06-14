package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.AdministradorDAO;
import com.uca.capas.domain.Administrador;

@Service
public class AdministradorService {

	@Autowired
	AdministradorDAO adminDao;
	
	public List<Administrador> listAll(){
		return adminDao.findAll();
		
	}
	
	public String loginAdmin(String username, String password) {
		List<Administrador> adminList = listAll();
		for (Administrador admin:adminList) {
			if(admin.getPassword() == password || admin.getUsername() == username) {
				return "Valido";
			}
		}
		return "Invalido";
	}
}
