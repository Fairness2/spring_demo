package ru.geekbrains.spring_demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.geekbrains.spring_demo.model.entity.User;
import ru.geekbrains.spring_demo.model.entity.UserProduct;
import ru.geekbrains.spring_demo.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    /*@Autowired
    private UserService userService;

    @GetMapping("/")
    public String showHomePage(Model model) {
       model.addAttribute("users", userService.getAll());
       return "users/index";
    }

    @GetMapping("/{id}")
    public String showHomePage(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getOne(id));
        return "users/one";
    }

    @GetMapping("/add")
    public String showAddForm(RedirectAttributes redirectAttributes, Model model) {
        User user = (User) redirectAttributes.getAttribute("user");
        model.addAttribute("user", user);
        return "users/add_form";
    }

    @GetMapping("/update")
    public String showUpdateForm(RedirectAttributes redirectAttributes, Model model) {
        User user = (User) redirectAttributes.getAttribute("user");
        model.addAttribute("user", user);
        return "users/update_form";
    }

    @GetMapping("/delete")
    public String showDeleteForm(RedirectAttributes redirectAttributes, Model model) {
        return "users/delete_form";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String name, RedirectAttributes redirectAttributes) {
        User user = userService.add(name);
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/users/add";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam Integer id, @RequestParam String name, RedirectAttributes redirectAttributes) {
        User user = userService.update(id, name);
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/users/update";
    }

    @PostMapping("/delete")
    public String addUser(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        userService.delete(id);
        return "redirect:/users/";
    }

    @GetMapping("/{id}/products")
    public String showUsersProducts(@PathVariable Integer id, Model model) {
        User user = userService.getOne(id);
        List<UserProduct> userProductList = userService.userProducts(user);
        model.addAttribute("user", user);
        model.addAttribute("userProducts", userProductList);
        return "users/products";
    }*/
}
