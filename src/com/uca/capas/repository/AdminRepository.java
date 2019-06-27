package com.uca.capas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Administrador;

@Repository
public interface AdminRepository extends JpaRepository<Administrador,Integer> {

	
	public Administrador getOne(Integer dato);
}
