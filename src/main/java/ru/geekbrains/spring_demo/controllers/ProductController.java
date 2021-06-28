package ru.geekbrains.spring_demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.geekbrains.spring_demo.model.Product;
import ru.geekbrains.spring_demo.services.ProductService;

import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showHomePage(Model model) {
       model.addAttribute("products", productService.getAll());
       return "products/index";
    }

    @GetMapping("/{uuid}")
    public String showHomePage(@PathVariable UUID uuid, Model model) {
        model.addAttribute("product", productService.getOne(uuid));
        return "products/one";
    }

    @GetMapping("/add")
    public String showAddForm(RedirectAttributes redirectAttributes, Model model) {
        Product product = (Product) redirectAttributes.getAttribute("product");
        model.addAttribute("products", product);
        return "products/add_form";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String title, @RequestParam int cost, RedirectAttributes redirectAttributes) {
        Product product = productService.add(title, cost);
        redirectAttributes.addFlashAttribute("product", product);
        return "redirect:/products/add";
    }
}
