package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.UsuarioDAO;
import com.uca.capas.domain.Usuario;

@Service
public class UsuarioService {
	@Autowired
	UsuarioDAO usuarioDao;
	
	
	public List<Usuario> listAll(){
		return usuarioDao.findAll();
	}
	
	public String login(String username, String password) {
		username = username.toLowerCase();
		List<Usuario> usrList = usuarioDao.findAll();
		String login ="Invalido";
		for(Usuario user:usrList) {
			String usernameUser = user.getUsername().toLowerCase();
			String passwordUser = user.getPassword();
			if(usernameUser.equals(username) && passwordUser.equals(password)) {
				login = "Valido";
				break;
			}
		}
		return login;
		
	}
	
}
