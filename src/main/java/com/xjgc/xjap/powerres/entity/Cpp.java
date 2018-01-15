package com.xjgc.xjap.powerres.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Cpp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cpp", catalog = "e8000")

public class Cpp implements java.io.Serializable {

	// Fields

	private CppId id;

	// Constructors

	/** default constructor */
	public Cpp() {
	}

	/** full constructor */
	public Cpp(CppId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id") ),
			@AttributeOverride(name = "datetime", column = @Column(name = "datetime", length = 19) ),
			@AttributeOverride(name = "value", column = @Column(name = "value") ) })

	public CppId getId() {
		return this.id;
	}

	public void setId(CppId id) {
		this.id = id;
	}

}