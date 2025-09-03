package com.leandrodev.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandrodev.workshopmongo.domain.User;

@RestController
@RequestMapping(value ="/users")
public class UserResources {

	@GetMapping
	public ResponseEntity<List<User> > findAll(){
		User maria = new User("1", "MAria Alice", "MariaA@gmail.com");
		User Alex = new User("2", "Alex Santos", "Alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, Alex));
		return ResponseEntity.ok().body(list);
	}

}
