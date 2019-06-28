package com.uca.capas.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.AdministradorDAO;
import com.uca.capas.domain.Administrador;
import com.uca.capas.repository.AdminRepository;

@Service
public class AdministradorService {

	@Autowired
	AdministradorDAO adminDao;
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	AdminRepository adminRepo;
	
	public List<Administrador> listAll(){
		return adminRepo.findAll();
		
	}
	
	@Transactional
	public Boolean editarAdmin(Administrador admin) {
		entityManager.merge(admin);
		entityManager.flush();
		return true;
		
	}
	
	@Transactional
	public void logoutAdmin(String username) {
		List<Administrador> adminList = listAll();
		for (Administrador admin:adminList) {
			String usernameAdmin = admin.getUsername().toLowerCase();
			String passwordAdmin = admin.getPassword();
			if(usernameAdmin.equals(username)) {

				admin.setSession(false);
				editarAdmin(admin);
			}
		}
	}
	
	@Transactional
	public String loginAdmin(String username, String password) {
		username = username.toLowerCase();
		List<Administrador> adminList = listAll();
		for (Administrador admin:adminList) {
			String usernameAdmin = admin.getUsername().toLowerCase();
			String passwordAdmin = admin.getPassword();
			Boolean sessionAdmin = admin.getSession();
			if(usernameAdmin.equals(username) && passwordAdmin.equals(password) ) {
				if(!sessionAdmin) {
				admin.setSession(true);
				editarAdmin(admin);
				return "Valido" + admin.getUsername();
				}
				else {
					return "Already logged in";
				}
			}
			else {
				
			}
		}
		return "Credenciales incorrectas";
		
	}
}
