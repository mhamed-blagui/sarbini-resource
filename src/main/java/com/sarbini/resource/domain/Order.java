package com.sarbini.resource.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sarbini.resource.enums.OrderStateEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SAR_ORDER", schema = "SARBINI")
@Getter
@Setter
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2141634501964059305L;

	@GeneratedValue
	@Id
	@Column(name= "ID")
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
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "PROVIDER", referencedColumnName = "PROVIDER", insertable = false, updatable = false),
		@JoinColumn(name = "NAME", referencedColumnName = "NAME", insertable = false, updatable = false) })
	private Product product;
	
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
}
