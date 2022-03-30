//package ru.bonbon.SpringTest.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Map;
//
//@Controller
//public class MainController {
//    @GetMapping("/")
//    public String home(@RequestParam(name = "name", required = false, defaultValue = "Пусто") String arg1, Model model){
//        System.out.println("home метод работает");
//        model.addAttribute("title", arg1);
//        return "index";
//    }
//    @PostMapping("/")
//    public String doPost(@RequestParam Map<String, String> map, Model model){
//        System.out.println("doPost метод работает");
//        model.addAttribute("title", map.get("name"));
//        return "index";
//    }
//}
