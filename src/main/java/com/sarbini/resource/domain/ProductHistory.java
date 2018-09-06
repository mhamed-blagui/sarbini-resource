package com.sarbini.resource.domain;

import static com.sarbini.resource.constant.Constants.SARBINI_SCHEMA_NAME;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SAR_PRODUCT_HISTORY", schema = SARBINI_SCHEMA_NAME)
@Getter
@Setter
public class ProductHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6780972401369178839L;

	@Id
	@SequenceGenerator(name = "sequenceGenerator", schema = SARBINI_SCHEMA_NAME, sequenceName = "PRODUCT_HIST_SEQ")
	@GeneratedValue(generator = "sequenceGenerator")
	private Long id;
}
