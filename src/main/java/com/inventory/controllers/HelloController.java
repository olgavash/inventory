package com.inventory.controllers;

import com.inventory.models.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String helloForm(Model model) {
        model.addAttribute("hello", new Hello());
        return "hello";
    }

    @PostMapping("/hello")
    public String helloSubmit(@ModelAttribute Hello hello) {
        return "result";
    }

}
