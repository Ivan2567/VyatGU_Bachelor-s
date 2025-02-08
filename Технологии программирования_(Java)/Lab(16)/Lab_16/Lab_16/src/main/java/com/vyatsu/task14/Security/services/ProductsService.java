package com.vyatsu.task14.Security.services;

import com.vyatsu.task14.entities.Product;
import com.vyatsu.task14.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Page<Product> getProduct (Specification<Product> specification, PageRequest pageable){
        return productRepository.findAll(specification,pageable);
    }
    public Product getbyId(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public void deleteById(Long id){
        productRepository.deleteById( id);
    }
    public void saveOrUpdate(Product product){
        productRepository.save(product);
    }
//    public void deleteById(int id) {
//        productRepository.delete(id);
//    }
//
//    public List<Product> getAllProducts(Integer x,Integer y,String z) {
//        return productRepository.findAll(x, y, z);
//    }
//
//    public void add(String x,Integer y) {
//       productRepository.add;
//    }
//
//    public void changeById(Integer id,String z,Integer y) {
//        productRepository.
//        productRepository.change(id,z,y);
//    }
//
}
