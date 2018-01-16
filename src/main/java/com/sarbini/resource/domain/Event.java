package com.sarbini.resource.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SAR_EVENT", schema = "SARBINI")
@Getter
@Setter
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4623239222946881575L;

	@NotNull
	@Size(min = 0, max = 50)
	@Id
	@Column(length = 50)
	private String name;
}
