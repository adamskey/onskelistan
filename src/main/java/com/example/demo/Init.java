package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

//@Configuration
@Service
public class Init implements CommandLineRunner  {
    @Autowired
    ProductRepository productRepo;
    @Autowired
    UserRepository userRepo;

    @Override
    public void run(String[] args) {
        Wisher user = new Wisher("admin", "admin", "admin@admin.com", "admin");
        user = userRepo.save(user);
        Product product = new Product(null, "Bibel", "Jesus", 100);
        product.setWisher(user);
        productRepo.save(product);
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
