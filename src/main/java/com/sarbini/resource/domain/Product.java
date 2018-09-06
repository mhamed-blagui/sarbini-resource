package com.sarbini.resource.domain;

import static com.sarbini.resource.constant.Constants.SARBINI_SCHEMA_NAME;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sarbini.resource.enums.ProductStateEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SAR_PRODUCT", schema = SARBINI_SCHEMA_NAME)
@Getter
@Setter
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7596256455633948774L;

	
	@Id
	@SequenceGenerator(name = "sequenceGenerator", schema = SARBINI_SCHEMA_NAME, sequenceName = "PRODUCT_SEQ")
	@GeneratedValue(generator = "sequenceGenerator")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "PROVIDER")
	private User provider;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRICE")
	private BigDecimal price;
	
	@Column(name ="CURRENT_STATE")
	@Enumerated(EnumType.STRING)
	private ProductStateEnum currentState;
}
