package com.aforo255.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.aforo255.entity.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(@Param("username") String username);
}
