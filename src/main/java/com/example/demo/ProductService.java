package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> books;

    public ProductService() {
        books = new ArrayList<>();

        for (int i = 1; i <= 95; i++) {
            books.add(new Product(200L+i, "Product Title " + i, 40 + i));
        }
    }

    public Product getBook(Long id) {
        for (Product book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Product book) {
        books.add(book);
    }

    public List<Product> getBooks() {
        return books;
    }
}
