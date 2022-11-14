package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/customers")
    public String customers(Model model) {
        List<Wisher> customers = (List<Wisher>)repository.findAll();
        model.addAttribute("customers", customers);

        return "customers";
    }

    @GetMapping("/addCustomer")
    public String add(Model model) {
        model.addAttribute("customer", new Wisher());
        return "customerForm";
    }

    @PostMapping("/saveCustomer")
    public String set(@ModelAttribute Wisher customer) {
        repository.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("/")
    public String userLogin(Model model){
        model.addAttribute("user", new Wisher());
        return "login";
    }
    @PostMapping("/")
    public String login(HttpSession session, @ModelAttribute Wisher user) {
        Wisher wisher = repository.findByFirstNameAndPassword(user.firstName, user.password);
        if (wisher != null) {
            session.setAttribute("username", user.getFirstName());
            return "books";
        }
        return "redirect:/";
    }
}
