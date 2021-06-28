package ru.geekbrains.spring_demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.NestedServletException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            switch (Integer.parseInt(status.toString())) {
                case 404 -> model.addAttribute("message", "Страница не найдена");
                case 500 -> {
                    String message = ((NestedServletException) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION)).getCause().getMessage();//Как-то грубо, скорее всего есть какой-то другой способ достать нужное сообщение?
                    model.addAttribute("message", message);
                }
                default -> model.addAttribute("message", "");
            }
        }
        else {
            model.addAttribute("message", request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        }

        model.addAttribute("code", status);
        return "error";
    }
}
