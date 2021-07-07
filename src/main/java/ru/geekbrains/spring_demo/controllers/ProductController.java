package ru.geekbrains.spring_demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.geekbrains.spring_demo.model.HiProduct;
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

    @GetMapping("/{id}")
    public String showHomePage(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getOne(id));
        return "products/one";
    }

    @GetMapping("/add")
    public String showAddForm(RedirectAttributes redirectAttributes, Model model) {
        HiProduct product = (HiProduct) redirectAttributes.getAttribute("product");
        model.addAttribute("products", product);
        return "products/add_form";
    }

    @GetMapping("/update")
    public String showUpdateForm(RedirectAttributes redirectAttributes, Model model) {
        HiProduct product = (HiProduct) redirectAttributes.getAttribute("product");
        model.addAttribute("products", product);
        return "products/update_form";
    }

    @GetMapping("/delete")
    public String showDeleteForm(RedirectAttributes redirectAttributes, Model model) {
        return "products/delete_form";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String title, @RequestParam int cost, RedirectAttributes redirectAttributes) {
        HiProduct product = productService.add(title, cost);
        redirectAttributes.addFlashAttribute("product", product);
        return "redirect:/products/add";
    }

    @PostMapping("/update")
    public String addProduct(@RequestParam Integer id, @RequestParam String title, @RequestParam int cost, RedirectAttributes redirectAttributes) {
        HiProduct product = productService.update(id, title, cost);
        redirectAttributes.addFlashAttribute("product", product);
        return "redirect:/products/update";
    }

    @PostMapping("/delete")
    public String addProduct(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        return "redirect:/products/";
    }
}
