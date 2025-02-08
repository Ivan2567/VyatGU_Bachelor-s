package com.vyatsu.task14.repositories;

import com.vyatsu.task14.entities.Product;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long>, JpaSpecificationExecutor<Product> {
    List<Product> findAllByPrice(double price, Pageable pageable);
}
