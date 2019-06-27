package com.uca.capas.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uca.capas.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

	public List<Usuario> findAll();
	
	public Usuario getOne(Integer dato);

	
}
