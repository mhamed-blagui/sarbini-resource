package com.sarbini.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarbini.resource.domain.Product;
import com.sarbini.resource.domain.ProductID;

@Repository
public interface ProductRepository extends JpaRepository<Product, ProductID>{

}
