package ru.bonbon.SpringTest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "Домашняя страница";
    }
}
