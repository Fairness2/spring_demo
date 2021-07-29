package ru.geekbrains.spring_demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_demo.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/score")
public class ScoreController {
    @Autowired
    private UserService userService;

    @GetMapping("/inc")
    public Integer increaseUserScore(Principal principal, @RequestParam(defaultValue = "1") Integer score) {
        return userService.increaseUserScore(principal.getName(), score);
    }

    @GetMapping("/dec")
    public Integer decreaseUserScore(Principal principal, @RequestParam(defaultValue = "1") Integer score) {
        return userService.decreaseUserScore(principal.getName(), score);
    }

    @GetMapping("/get/current")
    public Integer getScore(Principal principal) {
        return userService.getUserScore(principal.getName());
    }

    @GetMapping("/get/{id}")
    public Integer getScore(@PathVariable Integer id) {
        return userService.getUserScore(id);
    }
}
