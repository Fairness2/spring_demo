package ru.geekbrains.spring_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String main(Model model) {
        return "index";
    }

    @GetMapping("/products")
    public String products(Model model) {
        return "index";
    }
}
