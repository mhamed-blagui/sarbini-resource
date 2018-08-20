package com.sarbini.resource.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sarbini.resource.enums.OrderStateEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SAR_ORDER_HISTORY", schema = "SARBINI")
@Getter
@Setter
public class OrderHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8668775924761071232L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	private Long id;
	
	@Column(name = "ORDER_ID")
	private String orderId;
	
	@Column(name ="STATE")
	@Enumerated(EnumType.STRING)
	private OrderStateEnum state;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
}
