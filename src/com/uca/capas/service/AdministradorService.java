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
		username = username.toLowerCase();
		List<Administrador> adminList = listAll();
		for (Administrador admin:adminList) {
			String usernameAdmin = admin.getUsername().toLowerCase();
			String passwordAdmin = admin.getPassword();
			if(usernameAdmin.equals(username) && passwordAdmin.equals(password)) {
				return "Valido";
			}
		}
		return "Invalido";
	}
}
