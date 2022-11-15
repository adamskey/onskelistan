package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	UserRepository UserRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void test1() {
		Wisher wisher = UserRepository.findByFirstNameAndPassword("tomten", "tomten");
		Assertions.assertEquals("tomten", wisher.getFirstName());
		Assertions.assertEquals("tomten", wisher.getPassword());

	}
}
