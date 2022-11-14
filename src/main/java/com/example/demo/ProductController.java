package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private ProductRepository repository;

    @GetMapping("/")
    public String books(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {

        List<Product> books = getPage(page-1, PAGE_SIZE);
        int pageCount = numberOfPages(PAGE_SIZE);
        int[] pages = toArray(pageCount);

        model.addAttribute("books", books);
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("showPrev", page > 1);
        model.addAttribute("showNext", page < pageCount);

        return "books";
    }

    @GetMapping("/book/{page}/{id}")
    public String book(Model model, @PathVariable Integer page, @PathVariable Long id) {
        Product book = repository.findById(id).orElse(null);
        model.addAttribute("page", page);
        model.addAttribute("book", book);

        return "book";
    }


    private int[] toArray(int num) {
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i+1;
        }
        return result;
    }

    private List<Product> getPage(int page, int pageSize) {
        List<Product> books = (List<Product>)repository.findAllByOrderByName();
        int from = Math.max(0,page*pageSize);
        int to = Math.min(books.size(),(page+1)*pageSize);

        return books.subList(from, to);
    }

    private int numberOfPages(int pageSize) {
        List<Product> books = (List<Product>)repository.findAll();
        return (int)Math.ceil(new Double(books.size()) / pageSize);
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "form";
    }

    @PostMapping("/save")
    public String set(@ModelAttribute Product book) {
        repository.save(book);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Product book = repository.findById(id).get();

        model.addAttribute(book);
        return "form";
    }

    @PostMapping("/edit/{id}")
    public String set2(@ModelAttribute Product book) {
        repository.save(book);

        return "redirect:/";
    }

}
