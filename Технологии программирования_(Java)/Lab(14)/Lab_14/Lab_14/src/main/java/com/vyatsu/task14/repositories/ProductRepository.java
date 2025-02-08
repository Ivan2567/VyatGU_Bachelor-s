package com.vyatsu.task14.repositories;

import com.vyatsu.task14.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;
    private List<Product> tempProduct;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(0, "Bread", 40));
        products.add(new Product(1, "Milk", 90));
        products.add(new Product(2, "Cheese", 200));
    }

    public List<Product> findAll() {
        return tempProduct;
    }
    public List<Product> findFilter(int min, int max) {
        tempProduct = new ArrayList<>();
        if (this.tempProduct != null) this.tempProduct.clear();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() >= min && products.get(i).getPrice() <= max){
                 System.out.println(products.get(i));
                 this.tempProduct.add(products.get(i));
            }
        }
        for (int i = 0; i < this.tempProduct.size(); i++) {
            System.out.println(
                    this.tempProduct.get(i).getTitle() +" ||| " +
                            this.tempProduct.get(i).getPrice());
        }

        return this.tempProduct;
    }

    public Product findByTitle(String title) {
        return products.stream().filter(p -> p.getTitle().equals(title)).findFirst().get();
    }


    public Product findById(int id) {
        for (Product p:products) {
            if(p.getId() == id) return p;
        }
        return null;
    }

    public void save(Product product) {
        products.add(new Product(products.size(), product.getTitle(),product.getPrice()));
    }
    public void saveEdit(Product product) {
        //System.out.println("3 "+ product.getId() + "|" +product.getTitle() + "|" + product.getPrice());
        int id = product.getId();
        products.get(id).setEdit(product.getId(),product.getTitle(), product.getPrice());
    }
}
