package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Analprdlmt entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "analprdlmt", catalog = "e8000")

public class Analprdlmt implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer periodCount;
	private String upperValueList;
	private String lowerValueList;
	private String uupperValueList;
	private String llowerValueList;
	private String upperValueList3;
	private String lowerValueList3;
	private String upperValueList4;
	private String lowerValueList4;

	// Constructors

	/** default constructor */
	public Analprdlmt() {
	}

	/** minimal constructor */
	public Analprdlmt(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Analprdlmt(Integer id, Integer periodCount, String upperValueList, String lowerValueList,
			String uupperValueList, String llowerValueList, String upperValueList3, String lowerValueList3,
			String upperValueList4, String lowerValueList4) {
		this.id = id;
		this.periodCount = periodCount;
		this.upperValueList = upperValueList;
		this.lowerValueList = lowerValueList;
		this.uupperValueList = uupperValueList;
		this.llowerValueList = llowerValueList;
		this.upperValueList3 = upperValueList3;
		this.lowerValueList3 = lowerValueList3;
		this.upperValueList4 = upperValueList4;
		this.lowerValueList4 = lowerValueList4;
	}

	// Property accessors
	@Id

	@Column(name = "ID", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "PeriodCount")

	public Integer getPeriodCount() {
		return this.periodCount;
	}

	public void setPeriodCount(Integer periodCount) {
		this.periodCount = periodCount;
	}

	@Column(name = "UpperValueList", length = 1024)

	public String getUpperValueList() {
		return this.upperValueList;
	}

	public void setUpperValueList(String upperValueList) {
		this.upperValueList = upperValueList;
	}

	@Column(name = "LowerValueList", length = 1024)

	public String getLowerValueList() {
		return this.lowerValueList;
	}

	public void setLowerValueList(String lowerValueList) {
		this.lowerValueList = lowerValueList;
	}

	@Column(name = "UUpperValueList", length = 1024)

	public String getUupperValueList() {
		return this.uupperValueList;
	}

	public void setUupperValueList(String uupperValueList) {
		this.uupperValueList = uupperValueList;
	}

	@Column(name = "LLowerValueList", length = 1024)

	public String getLlowerValueList() {
		return this.llowerValueList;
	}

	public void setLlowerValueList(String llowerValueList) {
		this.llowerValueList = llowerValueList;
	}

	@Column(name = "UpperValueList3", length = 1024)

	public String getUpperValueList3() {
		return this.upperValueList3;
	}

	public void setUpperValueList3(String upperValueList3) {
		this.upperValueList3 = upperValueList3;
	}

	@Column(name = "LowerValueList3", length = 1024)

	public String getLowerValueList3() {
		return this.lowerValueList3;
	}

	public void setLowerValueList3(String lowerValueList3) {
		this.lowerValueList3 = lowerValueList3;
	}

	@Column(name = "UpperValueList4", length = 1024)

	public String getUpperValueList4() {
		return this.upperValueList4;
	}

	public void setUpperValueList4(String upperValueList4) {
		this.upperValueList4 = upperValueList4;
	}

	@Column(name = "LowerValueList4", length = 1024)

	public String getLowerValueList4() {
		return this.lowerValueList4;
	}

	public void setLowerValueList4(String lowerValueList4) {
		this.lowerValueList4 = lowerValueList4;
	}

}