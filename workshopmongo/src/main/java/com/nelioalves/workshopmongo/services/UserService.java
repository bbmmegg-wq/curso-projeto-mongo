package com.nelioalves.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public List <User> findAll(){
		return repository.findAll();
		
	}
	
	

	@PostConstruct
	public void debugMongo() {
	    System.out.println("🔥 USERS NO BANCO: " + repository.findAll().size());
	}


}
