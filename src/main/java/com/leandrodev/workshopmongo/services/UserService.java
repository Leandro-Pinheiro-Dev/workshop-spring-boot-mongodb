package com.leandrodev.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandrodev.workshopmongo.domain.User;
import com.leandrodev.workshopmongo.repository.UserRepository;
import com.leandrodev.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	// Buscar todos os usuários
	public List<User> findAll() {
		return repo.findAll();
	}
	
	// Buscar usuário por ID
	public User findById(String id) {
		return repo.findById(id)
				   .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
