package com.sarbini.resource.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
}
