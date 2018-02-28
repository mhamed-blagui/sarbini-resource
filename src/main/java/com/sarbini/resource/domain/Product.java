package com.sarbini.resource.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SAR_PRODUCT", schema = "SARBINI")
@Getter
@Setter
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7596256455633948774L;

	
	@Id
	private ProductID id;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRICE")
	private BigDecimal price;
}
