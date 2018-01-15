package com.xjgc.xjap.powerres.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CppId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class CppId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp datetime;
	private Integer value;

	// Constructors

	/** default constructor */
	public CppId() {
	}

	/** full constructor */
	public CppId(Integer id, Timestamp datetime, Integer value) {
		this.id = id;
		this.datetime = datetime;
		this.value = value;
	}

	// Property accessors

	@Column(name = "id")

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "datetime", length = 19)

	public Timestamp getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	@Column(name = "value")

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CppId))
			return false;
		CppId castOther = (CppId) other;

		return ((this.getId() == castOther.getId())
				|| (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
				&& ((this.getDatetime() == castOther.getDatetime()) || (this.getDatetime() != null
						&& castOther.getDatetime() != null && this.getDatetime().equals(castOther.getDatetime())))
				&& ((this.getValue() == castOther.getValue()) || (this.getValue() != null
						&& castOther.getValue() != null && this.getValue().equals(castOther.getValue())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result + (getDatetime() == null ? 0 : this.getDatetime().hashCode());
		result = 37 * result + (getValue() == null ? 0 : this.getValue().hashCode());
		return result;
	}

}