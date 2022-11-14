package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/customers")
    public String customers(Model model) {
        List<User> customers = (List<User>)repository.findAll();
        model.addAttribute("customers", customers);

        return "customers";
    }

    @GetMapping("/addCustomer")
    public String add(Model model) {
        model.addAttribute("customer", new User());
        return "customerForm";
    }

    @PostMapping("/saveCustomer")
    public String set(@ModelAttribute User customer) {
        repository.save(customer);
        return "redirect:/customers";
    }
}
