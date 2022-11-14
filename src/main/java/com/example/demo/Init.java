package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//@Configuration
public class Init implements CommandLineRunner  {
    @Autowired
    ProductRepository bookRepository;

    @Autowired
    UserRepository customerRepository;

    @Override
    public void run(String[] args) {
        if (bookRepository.count() == 0) {


        bookRepository.save(new Product(null, "The Iliad - with CommandLineRunner", "Homer", 300));
        bookRepository.save(new Product(null, "The Hitchhikers Guide to the Galaxy - with CommandLineRunner", "Douglas Adams", 500));
        bookRepository.save(new Product(null, "Pippi Longstocking - with CommandLineRunner", "Astrid Lindgren", 250));

        customerRepository.save(new User("Donald", "Duck", "donald@disney.com", "123"));
        customerRepository.save(new User("Daisy", "Duck", "daisy@disney.com", "abc"));
        customerRepository.save(new User("Scrooge", "McDuck", "scrooge@disney.com", "321"));
        }
    }

	/*
	The CommandLineRunner run method is exactly like using this in data.sql (except the change in the title of the books):

	INSERT INTO BOOK (TITLE, AUTHOR, PRICE) VALUES ('The Iliad', 'Homer', 300);
	INSERT INTO BOOK (TITLE, AUTHOR, PRICE) VALUES ('The Hitchhikers Guide to the Galaxy', 'Douglas Adams', 500);
	INSERT INTO BOOK (TITLE, AUTHOR, PRICE) VALUES ('Pippi Longstocking', 'Astrid Lindgren', 250);

	INSERT INTO CUSTOMER (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, PASSWORD) VALUES('Donald', 'Duck', 'donald@disney.com', '123');
	INSERT INTO CUSTOMER (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, PASSWORD) VALUES('Daisy', 'Duck', 'daisy@disney.com', 'abc');
	INSERT INTO CUSTOMER (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, PASSWORD) VALUES('Scrooge', 'McDuck', 'scrooge@disney.com', '321');
	 */
}
