package com.nelioalves.workshopmongo.services;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional <Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle (String text){
		
		return repository.searchTitle(text);
	}
	
	public List <Post> fullSearch (String text, LocalDate minDate, LocalDate maxDate){
		Instant minInstant = minDate.atStartOfDay(ZoneOffset.UTC).toInstant();
		Instant maxInstant = maxDate.plusDays(1).atStartOfDay(ZoneOffset.UTC).toInstant();
		return repository.fullSearch(text, minInstant, maxInstant);
		}
}
