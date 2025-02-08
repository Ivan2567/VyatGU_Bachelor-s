package com.vyatsu.task14.controllers;

import com.vyatsu.task14.entities.Filtr;
import com.vyatsu.task14.entities.Product;
import com.vyatsu.task14.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String showProductsList(Model model) {
        Product product = new Product();
        Filtr filtr = new Filtr();
        model.addAttribute("products", productsService.getAllProducts());
        model.addAttribute("product", product);
        model.addAttribute("filter", filtr);
        return "products";
    }
    @GetMapping ("/filter/{min}&{max}&{name}")
    public String filterProduct(Model model,
                                @RequestParam (required = false, defaultValue = "", name = "min") String min,
                                @RequestParam (required = false, defaultValue = "", name = "max") String max,
                                @RequestParam (required = false, defaultValue = "", name = "name") String name)
    {
        Product product = new Product();
        Filtr filtr = new Filtr();
        int parseMax = productsService.getMaxCost();
        int parseMin = 0;

        if(!max.equals("") && !max.equals(null))
            parseMax = Integer.parseInt(max);
        if(!min.equals("") && !min.equals(null))
            parseMin = Integer.parseInt(min);

        filtr.setMax(max);
        filtr.setMin(min);
        filtr.setName(name);
        model.addAttribute("products", productsService.getFilterProducts(parseMin, parseMax, name));
        model.addAttribute("product", product);
        model.addAttribute("filter", filtr);
        return "products";
    }

    @PostMapping("/addedit")
    public String addProduct(@ModelAttribute(value = "product")Product product) {
        List<Product> products = productsService.getAllProducts();
        if(productsService.getById(product.getId()) != null)
            productsService.edit(product);
        else
        {
                product.setId(products.stream().count() + 1);
                productsService.add(product);
        }
        return "redirect:/products";
    }
    /*
    @PostMapping ("/edit")
    public String editProduct(@ModelAttribute (value = "product") Product product) {
        List<Product> products = productsService.getAllProducts();
        if(productsService.getById(product.getId()) != null)
            productsService.edit(product);
        else
        {
            Product p = productsService.getById(product.getId());
            if(p != null)
            {
                //Product tempP = productsService.getById(product.getId());
                p.setPrice(product.getPrice());
                productsService.edit(p);
            }
            else
            {
                product.setId(products.stream().count() + 1);
                productsService.add(product);
            }
        }
    	return "redirect:/products";
    }

     */

    @GetMapping("/show/{id}")
    public String showOneProduct(Model model, @PathVariable(value = "id") Long id) {
        Product product = productsService.getById(id);
        model.addAttribute("product", product);
        return "product-page";
    }
}
