package ru.geekbrains.spring_demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.geekbrains.spring_demo.model.HiProduct;
import ru.geekbrains.spring_demo.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<HiProduct> showHomePage(@RequestParam(defaultValue = "0") Integer min, @RequestParam(required = false) Integer max, @RequestParam(required = false) String like) {
        return productService.getAll(min, max, like);
    }

    @GetMapping("/{id}")
    public HiProduct showHomePage(@PathVariable Integer id) {
        return productService.getOne(id);
    }

    /*@GetMapping("/add")
    public String showAddForm(RedirectAttributes redirectAttributes, Model model) {
        HiProduct product = (HiProduct) redirectAttributes.getAttribute("product");
        model.addAttribute("product", product);
        return "products/add_form";
    }

    @GetMapping("/update")
    public String showUpdateForm(RedirectAttributes redirectAttributes, Model model) {
        HiProduct product = (HiProduct) redirectAttributes.getAttribute("product");
        model.addAttribute("product", product);
        return "products/update_form";
    }

    @GetMapping("/delete")
    public String showDeleteForm(RedirectAttributes redirectAttributes, Model model) {
        return "products/delete_form";
    }*/

    @PostMapping
    public HiProduct addProduct(@RequestBody HiProduct product, RedirectAttributes redirectAttributes) {
        productService.add(product);
        return product;
    }

    @PutMapping
    public HiProduct updateProduct(@RequestBody HiProduct product) {
        productService.update(product);
        return product;
    }

    @DeleteMapping
    public Integer addProduct(@RequestParam Integer id) {
        productService.delete(id);
        return id;
    }
}
