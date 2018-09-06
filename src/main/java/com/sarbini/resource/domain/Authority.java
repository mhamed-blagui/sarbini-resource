package com.sarbini.resource.domain;

import static com.sarbini.resource.constant.Constants.SARBINI_SCHEMA_NAME;
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
@Table(name = "SAR_AUTHORITY", schema = SARBINI_SCHEMA_NAME)
@Getter
@Setter
public class Authority implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2259882329822581961L;
	
	@NotNull
    @Size(min = 0, max = 50)
    @Id
    @Column(length = 50)
    private String name;

}
