package com.nisar.sample.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisar.sample.domain.Person;
import com.nisar.sample.repository.PersonRepos;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonRepos repo;
	
	private Logger log=LoggerFactory.getLogger(PersonController.class);
	
	@GetMapping("/{id}")
	public Person getById(@PathVariable(name = "id") int id) {
		
		return repo.findById(id).get();
	}
	@GetMapping()
 	public List<Person> getAll() {
		log.info("Logging Result");
		return repo.findAll();
	}

	@PostMapping
	public Person save(@RequestBody Person person) {
		
		return repo.save(person);
	}
 	@PutMapping
	public Person update(@RequestBody Person person) {
		
		return repo.findById(person.getId()).get();
	}
 	
 	@PatchMapping("/")
	public Person patch(@RequestBody Person person) {
		
		return null;
	}
 	
 	
 	
}
