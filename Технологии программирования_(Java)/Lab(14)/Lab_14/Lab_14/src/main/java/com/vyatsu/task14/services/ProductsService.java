package com.vyatsu.task14.services;

import com.vyatsu.task14.entities.Product;
import com.vyatsu.task14.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(int id) {
        return productRepository.findById(id);
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public List<Product> getFilterProduct(int min,int max) {
        return productRepository.findFilter(min,max);
    }

    public void add(Product product) {
        productRepository.save(product);
    }
    public void edit(Product product){
        productRepository.saveEdit(product);
    }
}
