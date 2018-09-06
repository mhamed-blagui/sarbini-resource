package com.sarbini.resource.rest.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarbini.resource.domain.Product;
import com.sarbini.resource.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductResource {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProductResource.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product/", method = GET)
	public ResponseEntity<List<Product>> listAllOrders() {
		List<Product> products = productService.findAllProducts();
		if (products.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
