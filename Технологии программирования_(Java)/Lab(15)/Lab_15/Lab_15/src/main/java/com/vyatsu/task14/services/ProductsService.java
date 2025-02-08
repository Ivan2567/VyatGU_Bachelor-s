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

    public void deleteById(int id) {
        productRepository.delete(id);
    }

    public List<Product> getAllProducts(Integer x,Integer y,String z) {
        return productRepository.findAll(x, y, z);
    }

    public void add(String x,Integer y) {
       productRepository.add(x, y);
    }

    public void changeById(Integer id,String z,Integer y) {
        productRepository.change(id,z,y);
    }

}
