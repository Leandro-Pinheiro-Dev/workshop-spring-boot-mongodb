package com.leandrodev.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandrodev.workshopmongo.domain.User;
import com.leandrodev.workshopmongo.dto.UserDTO;
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
	
	// Inserir novo usuário
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	// Deletar usuário por ID
	public void delete(String id) {
		findById(id); // garante que o usuário existe antes de deletar
		repo.deleteById(id);
	}
	
	// Atualizar usuário existente
	public User update(User obj) {
		User newObj = findById(obj.getId()); // busca garantindo que existe
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	// Copiar dados para atualização
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	// Converter DTO para entidade
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
