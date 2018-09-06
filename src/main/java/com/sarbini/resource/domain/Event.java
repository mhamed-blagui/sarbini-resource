package com.sarbini.resource.domain;

import static com.sarbini.resource.constant.Constants.SARBINI_SCHEMA_NAME;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SAR_EVENT")
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4623239222946881575L;

	@Id
	@SequenceGenerator(name = "sequenceGenerator", schema = SARBINI_SCHEMA_NAME, sequenceName = "EVENT_SEQ")
	@GeneratedValue(generator = "sequenceGenerator")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
}
