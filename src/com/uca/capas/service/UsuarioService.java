package com.uca.capas.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.UsuarioDAO;
import com.uca.capas.domain.Usuario;
import com.uca.capas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioDAO usuarioDao;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	UsuarioRepository usuarioRepo;
	
	public List<Usuario> listAll(){
		return usuarioDao.findAll();
	}
	
	public Usuario findUsuario(Integer id) {
		return usuarioDao.findUser(id);
	}
	
	@Transactional
	public Boolean editarUsuario(Usuario usuario) {
		entityManager.merge(usuario);
		entityManager.flush();
		return true;
	}
	
	@Transactional
	public void logout(Integer id) {
		Usuario usuario = usuarioRepo.findOne(id);
		usuario.setSession(false);
		editarUsuario(usuario);
	}
	
	@Transactional
	public String login(String username, String password) {
		username = username.toLowerCase();
		List<Usuario> usrList = usuarioDao.findAll();
		String login ="Invalido";
		for(Usuario user:usrList) {
			String usernameUser = user.getUsername().toLowerCase();
			String passwordUser = user.getPassword();
			if(usernameUser.equals(username) && passwordUser.equals(password)) {
				if(!user.getSession()) {
					if(user.getEstado()) {
					user.setSession(true);
					editarUsuario(user);
					login = "Valido"+user.getIdUsuario();
					break;}
					else {
						login ="Cuenta inactiva";
					}
				}
				else {
					login = "Already logged in"; 
					break;
			}
		}}
		return login;
		
	}
	
}
