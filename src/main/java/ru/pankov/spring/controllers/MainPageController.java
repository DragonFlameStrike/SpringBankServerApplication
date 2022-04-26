package ru.pankov.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String startPage(Model model){
        model.addAttribute("message","Hello");

        return "mainPage/startPage";
    }
}
