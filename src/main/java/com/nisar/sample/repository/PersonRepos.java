package com.nisar.sample.repository;


import org.springframework.data.jpa.repository.JpaRepository;
 
import org.springframework.stereotype.Repository;

import com.nisar.sample.domain.Person;

@Repository
public interface PersonRepos extends JpaRepository<Person,Integer>{

}
