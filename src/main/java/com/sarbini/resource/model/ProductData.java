package com.sarbini.resource.model;

import java.math.BigDecimal;

import com.sarbini.resource.domain.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductData {

	private String name;
	private String description;
	private BigDecimal price;
	private String userName;
	
	public void buildProductData(Product product) {
		setName(product.getName());
		setDescription(product.getDescription());
		setPrice(product.getPrice());
		setUserName(product.getProvider().getLogin());
	}

}
