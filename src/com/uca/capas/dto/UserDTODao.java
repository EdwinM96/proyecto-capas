package com.uca.capas.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDTODao {
	public List<UserDTO> loginUser(){
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
    EntityManager em = emf.createEntityManager();
    List<UserDTO> listaUsuarios=em.createQuery("select com.uca.capas.dto.UserDTO(username,password) from administrador", UserDTO.class).getResultList();
    List<UserDTO> listaAdmins=em.createQuery("select com.uca.capas.dto.UserDTO(username,password) from usuario", UserDTO.class).getResultList();
    List<UserDTO> lista = new ArrayList<UserDTO>();
    lista.addAll(listaUsuarios);
    lista.addAll(listaAdmins);
    return lista;
	}
}
