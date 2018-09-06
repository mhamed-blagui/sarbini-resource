package com.sarbini.resource.domain;

import static com.sarbini.resource.constant.Constants.SARBINI_SCHEMA_NAME;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sarbini.resource.enums.BatchNameEnum;
import com.sarbini.resource.enums.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SAR_BATCH_HISTORY", schema = SARBINI_SCHEMA_NAME)
@Getter
@Setter
public class BatchHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7125352391236568380L;

	@Id
	@SequenceGenerator(name = "sequenceGenerator", schema = SARBINI_SCHEMA_NAME, sequenceName = "BATCH_HIST_SEQ")
	@GeneratedValue(generator = "sequenceGenerator")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "NAME")
	private BatchNameEnum name;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private StatusEnum status;
	
	@Column(name = "CREATION_DATE")
	private Instant creationDate;
	
	@Column(name = "START_DATE")
	private Instant startDate;
	
	@Column(name = "END_DATE")
	private Instant endDate;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
}
