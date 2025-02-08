package com.vyatsu.task14.controllers;

//import com.sun.org.apache.xpath.internal.operations.Mod;
import com.vyatsu.task14.entities.Filteer;
import com.vyatsu.task14.entities.Product;
import com.vyatsu.task14.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.logging.FileHandler;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;
    public int minimumFilter = 0;
    public int maximumFilter = 100;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String showProductsList(Model model,
                                   @RequestParam(value = "minimum") int minimum,
                                   @RequestParam(value = "maximum") int maximum) {
        Product product = new Product();
        minimumFilter = minimum;
        maximumFilter = maximum;
        System.out.println("main " + minimumFilter +
                "  /  " + maximumFilter);
        model.addAttribute("products",
                productsService.getFilterProduct(minimumFilter, maximumFilter));
        model.addAttribute("product", product);
        return "products";
    }

    //@GetMapping
    //public String showFilterCount(Model models) {
    //    Filteer filteer = new Filteer(minimumFilter,maximumFilter);
    //    models.addAttribute("filteer", filteer);
    //    return "products";
    //}


    //@PostMapping("/filterPrice")
    //public String filterPriceProduct(
    //@RequestParam(value = "min") int min,
    //@RequestParam(value = "max") int max){
    //    minimumFilter = min;
    //    maximumFilter = max;
    //    System.out.println(minimumFilter + " / " + maximumFilter);
    //    System.out.println(min + " / " + max);
    //    return "redirect:/products";
    //}

    @PostMapping("/add")
    public String addProduct(@ModelAttribute(value = "product")Product product) {
        productsService.add(product);
        return "redirect:/products";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute(value = "product")Product product) {
        productsService.edit(product);
        //System.out.println(
        //        "1 " + product.getId() +
        //        "|" +product.getTitle() +
        //        "|" + product.getPrice());
        return "redirect:/products";
    }

    @GetMapping("/show/{id}")
    public String showOneProduct(Model model, @PathVariable(value = "id") int id) {
        Product product = productsService.getById(id);
        model.addAttribute("product", product);
        return "product-page";
    }
    @GetMapping("/show_edit/{id}")
    public String editOneProduct(Model model, @PathVariable(value = "id") int id) {
        Product product = productsService.getById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @GetMapping("/addcat")
    public String showAddCatForm(Model model) {
        System.out.println("get " + minimumFilter +
                "  /  " + maximumFilter);
        Filteer filteer = new Filteer(
                minimumFilter,
                maximumFilter);
        model.addAttribute("filteer", filteer);
        return "cat-form";
    }

    @PostMapping("/addcat")
    public String showAddCatForm
            (@ModelAttribute(value = "filteer") Filteer filteer) {
        System.out.println("post " + filteer.getMinimum() +
                "  /  " + filteer.getMaximum());
        minimumFilter = filteer.getMinimum();
        maximumFilter = filteer.getMaximum();
        return "products";
    }

    @PostMapping("/goproducts")
    public String goProducts
            (@ModelAttribute(value = "filteer") Filteer filteer) {
        System.out.println("post " + filteer.getMinimum() +
                "  /  " + filteer.getMaximum());
        minimumFilter = filteer.getMinimum();
        maximumFilter = filteer.getMaximum();
        return "products";
    }

    //@GetMapping("/filterPrice")
    //public String filterPriceProduct(Model model) {
    //    Filteer filteer = new Filteer(
    //            productsController.minimumFilter,
    //            productsController.maximumFilter);
    //    System.out.println(
    //            " get " + productsController.minimumFilter +
    //            "  /  " + productsController.maximumFilter);
    //    //model.addAttribute("filteer",filteer);
    //    //model.addAttribute("minimumFilter",minimumFilter);
    //    //model.addAttribute("maximumFilter",maximumFilter);
    //    return "redirect:/products";
    //}

    @PostMapping("/filterPrice")
    public String filterPriceProduct(){
        System.out.println("post " + minimumFilter +
                "  /  " + maximumFilter);
        return "cat-form";
    }
}