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

import com.sarbini.resource.enums.OperationNameEnum;
import com.sarbini.resource.enums.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SAR_OPERATION_HISTORY", schema = SARBINI_SCHEMA_NAME)
public class OperationHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3353364675600962502L;

	@Id
	@SequenceGenerator(name = "sequenceGenerator", schema = SARBINI_SCHEMA_NAME, sequenceName = "OPERATION_HIST_SEQ")
	@GeneratedValue(generator = "sequenceGenerator")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "NAME")
	private OperationNameEnum operationName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private StatusEnum operationStatus;
	
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Column(name = "DESCRIPTION")
	private String description;
}
