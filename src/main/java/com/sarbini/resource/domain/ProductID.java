package com.sarbini.resource.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ProductID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7480396981846982940L;

	@ManyToOne
	@JoinColumn(name = "PROVIDER")
	private User provider;
	
	@Column(name = "NAME")
	private String name;
}
