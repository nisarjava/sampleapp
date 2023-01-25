package com.nisar.sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import com.nisar.sample.domain.Person;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MorphyappApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private TestRestTemplate template;
	
	@Test
	@Order(1)
	public void add() {
		var person= new Person();
		person.setId(1);
		person.setFirstName("Test");
		person.setLastname("OK");
		person.setAge(10);
		var entity= new HttpEntity<Person>(person);
	    var response = template.exchange("/persons", HttpMethod.POST, entity, Void.class);
	    Assertions.assertEquals(200, response.getStatusCodeValue());
	}
		@Test
		@Order(2)
	public void getById() {
			var person = template.getForObject("/persons/{id}", Person.class,1);
		    Assertions.assertNotNull(person);
		    Assertions.assertEquals(1, person.getId());
		}
 


}
