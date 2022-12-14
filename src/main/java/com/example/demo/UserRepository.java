package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Wisher, Long> {

    Wisher findByFirstNameAndPassword(String firstName, String password);

}
