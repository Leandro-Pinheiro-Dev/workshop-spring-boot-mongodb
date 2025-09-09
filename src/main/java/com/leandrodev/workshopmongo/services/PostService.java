package com.leandrodev.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandrodev.workshopmongo.domain.Post;
import com.leandrodev.workshopmongo.repository.PostRepository;
import com.leandrodev.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		return repo.findById(id)
				   .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}