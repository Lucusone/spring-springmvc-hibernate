package com.xjgc.xjap.powerres.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Xmlpage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "xmlpage", catalog = "e8000")

public class Xmlpage implements java.io.Serializable {

	// Fields

	private XmlpageId id;

	// Constructors

	/** default constructor */
	public Xmlpage() {
	}

	/** full constructor */
	public Xmlpage(XmlpageId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id") ),
			@AttributeOverride(name = "equipclassid", column = @Column(name = "equipclassid") ),
			@AttributeOverride(name = "equipid", column = @Column(name = "equipid") ),
			@AttributeOverride(name = "path1", column = @Column(name = "path1") ),
			@AttributeOverride(name = "path2", column = @Column(name = "path2") ),
			@AttributeOverride(name = "path3", column = @Column(name = "path3") ) })

	public XmlpageId getId() {
		return this.id;
	}

	public void setId(XmlpageId id) {
		this.id = id;
	}

}