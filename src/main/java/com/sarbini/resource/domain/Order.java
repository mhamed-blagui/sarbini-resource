package com.sarbini.resource.domain;

import static com.sarbini.resource.constant.Constants.SARBINI_SCHEMA_NAME;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sarbini.resource.enums.OrderStateEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SAR_ORDER", schema = SARBINI_SCHEMA_NAME)
@Getter
@Setter
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2141634501964059305L;

	@Id
	@SequenceGenerator(name = "sequenceGenerator", schema = SARBINI_SCHEMA_NAME, sequenceName = "ORDER_SEQ")
	@GeneratedValue(generator = "sequenceGenerator")
	private Long id;
	
	@Column(name ="CURRENT_STATE")
	@Enumerated(EnumType.STRING)
	private OrderStateEnum currentState;
	
	@Column(name = "PAYED")
	private Boolean payed;
	
	@Column(name = "DELIVERED")
	private Boolean delivered;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER")
	private User customer;
	
	@ManyToOne
	@JoinColumn(name = "PROVIDER")
	private User provider;
	
	@ManyToOne
	@JoinColumn(name = "DELIVER")
	private User deliver;
	
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "SAR_ORDER_PRODUCT",  schema = "SARBINI", joinColumns = {
			@JoinColumn(name = "order_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "product_id", referencedColumnName = "id") })
	private Set<Product> products = new HashSet<>();
}
