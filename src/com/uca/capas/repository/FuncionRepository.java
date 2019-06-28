package com.uca.capas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Funcion;
import com.uca.capas.domain.Usuario;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion,Integer> {

	public Funcion getOne(Integer dato);
}
