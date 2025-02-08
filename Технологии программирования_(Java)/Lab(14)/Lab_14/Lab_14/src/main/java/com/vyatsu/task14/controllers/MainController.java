package com.vyatsu.task14.controllers;

import com.vyatsu.task14.entities.Filteer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/main")
public class MainController {
//    @GetMapping
//    public String index() {
//        return "index";
//    }
//
//    @GetMapping("/secured")
//    public String secured() {
//        return "index";
//    }
//
    @GetMapping("/form")
    public String showForm() {
        return "simple-form";
    }

    @PostMapping("/form")
    public String saveForm(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email) {
        System.out.println(name);
        System.out.println(email);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String doSomething() {
        return "index";
    }

    @GetMapping("/hello")
    public String helloRequest(Model model, @RequestParam(value = "name") String name) {
        model.addAttribute("name", name);
        return "hello";
    }



/*
    @GetMapping("/hello/{name}")
    public String helloRequest(Model model, @PathVariable(value = "name") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
*/

//    @GetMapping("/hello")
//    public String helloRequest(Model model) {
//        model.addAttribute("name", "Bob");
//        return "hello";
//    }


}
