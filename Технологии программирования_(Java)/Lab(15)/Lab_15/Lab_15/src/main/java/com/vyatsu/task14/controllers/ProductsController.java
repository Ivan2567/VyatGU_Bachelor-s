package com.vyatsu.task14.controllers;

import com.vyatsu.task14.entities.Product;
import com.vyatsu.task14.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("")
    public String Firste()
    {
        return "redirect:/products?Min=&Max=&Substring=";
    }


    @GetMapping("/products")
    public String ShowProducts(@RequestParam(value = "Min",required = false) Integer Min,
                               @RequestParam(value = "Max",required = false) Integer Max,
                               @RequestParam(value = "Substring",required = false) String Substring,
                               Model model)
    {
        Product product = new Product();
        model.addAttribute("products", productsService.getAllProducts(Min,Max,Substring));
        model.addAttribute("product", product);
        model.addAttribute("Min", Min);
        model.addAttribute("Max", Max);
        model.addAttribute("Substring", Substring);
        return "hello";
    }

    @GetMapping("/add")
    public String addProduct(@RequestParam(value = "Name") String Name,
                             @RequestParam(value = "Price") Integer Price)
    {
        productsService.add(Name,Price);
        return "redirect:/products?Min=&Max=&Substring=";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam(value = "id") int id)
    {
        productsService.deleteById(id);
        return "redirect:/products?Min=&Max=&Substring=";
    }

    @GetMapping("/change")
    public String changeProduct(@RequestParam(value = "ID") Integer id,
                                @RequestParam(value = "Name",required = false) String Name,
                                @RequestParam(value = "Price",required = false) Integer Price)
    {
        productsService.changeById(id,Name,Price);
        return "redirect:/products?Min=&Max=&Substring=";
    }
}
