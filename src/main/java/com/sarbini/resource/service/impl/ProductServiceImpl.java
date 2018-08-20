package com.sarbini.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarbini.resource.domain.Product;
import com.sarbini.resource.repository.ProductRepository;
import com.sarbini.resource.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAllProducts() {
		List<Product> products =productRepository.findAll();
		return products;
	}

}
