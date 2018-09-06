package com.sarbini.resource.domain;

import static com.sarbini.resource.constant.Constants.SARBINI_SCHEMA_NAME;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sarbini.resource.enums.OrderStateEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SAR_ORDER_HISTORY", schema = SARBINI_SCHEMA_NAME)
@Getter
@Setter
public class OrderHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8668775924761071232L;

	@Id
	@SequenceGenerator(name = "sequenceGenerator", schema = SARBINI_SCHEMA_NAME, sequenceName = "ORDER_HIST_SEQ")
	@GeneratedValue(generator = "sequenceGenerator")
	private Long id;
	
	@Column(name = "ORDER")
	private String order;
	
	@Column(name ="STATE")
	@Enumerated(EnumType.STRING)
	private OrderStateEnum state;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
}
