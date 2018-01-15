package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Alimittype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "alimittype", catalog = "e8000")

public class Alimittype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer ispercentum;
	private Integer periodflag;
	private Double deadzone;
	private Integer delaytime;
	private Double basevalue;
	private Double uppervalue;
	private Double lowervalue;
	private Double uuppervalue;
	private Double llowervalue;
	private Integer isfaultul;
	private Integer isfaultuull;
	private Integer upperalarmact;
	private Integer loweralarmact;
	private Integer uupperalarmact;
	private Integer lloweralarmact;
	private Double uppervalue3;
	private Double lowervalue3;
	private Double uppervalue4;
	private Double lowervalue4;
	private Integer isfault3;
	private Integer isfault4;
	private Integer upperalarmact3;
	private Integer loweralarmact3;
	private Integer upperalarmact4;
	private Integer loweralarmac4;

	// Constructors

	/** default constructor */
	public Alimittype() {
	}

	/** minimal constructor */
	public Alimittype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Alimittype(Integer id, String name, Integer ispercentum, Integer periodflag, Double deadzone,
			Integer delaytime, Double basevalue, Double uppervalue, Double lowervalue, Double uuppervalue,
			Double llowervalue, Integer isfaultul, Integer isfaultuull, Integer upperalarmact, Integer loweralarmact,
			Integer uupperalarmact, Integer lloweralarmact, Double uppervalue3, Double lowervalue3, Double uppervalue4,
			Double lowervalue4, Integer isfault3, Integer isfault4, Integer upperalarmact3, Integer loweralarmact3,
			Integer upperalarmact4, Integer loweralarmac4) {
		this.id = id;
		this.name = name;
		this.ispercentum = ispercentum;
		this.periodflag = periodflag;
		this.deadzone = deadzone;
		this.delaytime = delaytime;
		this.basevalue = basevalue;
		this.uppervalue = uppervalue;
		this.lowervalue = lowervalue;
		this.uuppervalue = uuppervalue;
		this.llowervalue = llowervalue;
		this.isfaultul = isfaultul;
		this.isfaultuull = isfaultuull;
		this.upperalarmact = upperalarmact;
		this.loweralarmact = loweralarmact;
		this.uupperalarmact = uupperalarmact;
		this.lloweralarmact = lloweralarmact;
		this.uppervalue3 = uppervalue3;
		this.lowervalue3 = lowervalue3;
		this.uppervalue4 = uppervalue4;
		this.lowervalue4 = lowervalue4;
		this.isfault3 = isfault3;
		this.isfault4 = isfault4;
		this.upperalarmact3 = upperalarmact3;
		this.loweralarmact3 = loweralarmact3;
		this.upperalarmact4 = upperalarmact4;
		this.loweralarmac4 = loweralarmac4;
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

	@Column(name = "NAME", length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ISPERCENTUM")

	public Integer getIspercentum() {
		return this.ispercentum;
	}

	public void setIspercentum(Integer ispercentum) {
		this.ispercentum = ispercentum;
	}

	@Column(name = "PERIODFLAG")

	public Integer getPeriodflag() {
		return this.periodflag;
	}

	public void setPeriodflag(Integer periodflag) {
		this.periodflag = periodflag;
	}

	@Column(name = "DEADZONE", precision = 22, scale = 0)

	public Double getDeadzone() {
		return this.deadzone;
	}

	public void setDeadzone(Double deadzone) {
		this.deadzone = deadzone;
	}

	@Column(name = "DELAYTIME")

	public Integer getDelaytime() {
		return this.delaytime;
	}

	public void setDelaytime(Integer delaytime) {
		this.delaytime = delaytime;
	}

	@Column(name = "BASEVALUE", precision = 22, scale = 0)

	public Double getBasevalue() {
		return this.basevalue;
	}

	public void setBasevalue(Double basevalue) {
		this.basevalue = basevalue;
	}

	@Column(name = "UPPERVALUE", precision = 22, scale = 0)

	public Double getUppervalue() {
		return this.uppervalue;
	}

	public void setUppervalue(Double uppervalue) {
		this.uppervalue = uppervalue;
	}

	@Column(name = "LOWERVALUE", precision = 22, scale = 0)

	public Double getLowervalue() {
		return this.lowervalue;
	}

	public void setLowervalue(Double lowervalue) {
		this.lowervalue = lowervalue;
	}

	@Column(name = "UUPPERVALUE", precision = 22, scale = 0)

	public Double getUuppervalue() {
		return this.uuppervalue;
	}

	public void setUuppervalue(Double uuppervalue) {
		this.uuppervalue = uuppervalue;
	}

	@Column(name = "LLOWERVALUE", precision = 22, scale = 0)

	public Double getLlowervalue() {
		return this.llowervalue;
	}

	public void setLlowervalue(Double llowervalue) {
		this.llowervalue = llowervalue;
	}

	@Column(name = "ISFAULTUL")

	public Integer getIsfaultul() {
		return this.isfaultul;
	}

	public void setIsfaultul(Integer isfaultul) {
		this.isfaultul = isfaultul;
	}

	@Column(name = "ISFAULTUULL")

	public Integer getIsfaultuull() {
		return this.isfaultuull;
	}

	public void setIsfaultuull(Integer isfaultuull) {
		this.isfaultuull = isfaultuull;
	}

	@Column(name = "UPPERALARMACT")

	public Integer getUpperalarmact() {
		return this.upperalarmact;
	}

	public void setUpperalarmact(Integer upperalarmact) {
		this.upperalarmact = upperalarmact;
	}

	@Column(name = "LOWERALARMACT")

	public Integer getLoweralarmact() {
		return this.loweralarmact;
	}

	public void setLoweralarmact(Integer loweralarmact) {
		this.loweralarmact = loweralarmact;
	}

	@Column(name = "UUPPERALARMACT")

	public Integer getUupperalarmact() {
		return this.uupperalarmact;
	}

	public void setUupperalarmact(Integer uupperalarmact) {
		this.uupperalarmact = uupperalarmact;
	}

	@Column(name = "LLOWERALARMACT")

	public Integer getLloweralarmact() {
		return this.lloweralarmact;
	}

	public void setLloweralarmact(Integer lloweralarmact) {
		this.lloweralarmact = lloweralarmact;
	}

	@Column(name = "UPPERVALUE3", precision = 22, scale = 0)

	public Double getUppervalue3() {
		return this.uppervalue3;
	}

	public void setUppervalue3(Double uppervalue3) {
		this.uppervalue3 = uppervalue3;
	}

	@Column(name = "LOWERVALUE3", precision = 22, scale = 0)

	public Double getLowervalue3() {
		return this.lowervalue3;
	}

	public void setLowervalue3(Double lowervalue3) {
		this.lowervalue3 = lowervalue3;
	}

	@Column(name = "UPPERVALUE4", precision = 22, scale = 0)

	public Double getUppervalue4() {
		return this.uppervalue4;
	}

	public void setUppervalue4(Double uppervalue4) {
		this.uppervalue4 = uppervalue4;
	}

	@Column(name = "LOWERVALUE4", precision = 22, scale = 0)

	public Double getLowervalue4() {
		return this.lowervalue4;
	}

	public void setLowervalue4(Double lowervalue4) {
		this.lowervalue4 = lowervalue4;
	}

	@Column(name = "ISFAULT3")

	public Integer getIsfault3() {
		return this.isfault3;
	}

	public void setIsfault3(Integer isfault3) {
		this.isfault3 = isfault3;
	}

	@Column(name = "ISFAULT4")

	public Integer getIsfault4() {
		return this.isfault4;
	}

	public void setIsfault4(Integer isfault4) {
		this.isfault4 = isfault4;
	}

	@Column(name = "UPPERALARMACT3")

	public Integer getUpperalarmact3() {
		return this.upperalarmact3;
	}

	public void setUpperalarmact3(Integer upperalarmact3) {
		this.upperalarmact3 = upperalarmact3;
	}

	@Column(name = "LOWERALARMACT3")

	public Integer getLoweralarmact3() {
		return this.loweralarmact3;
	}

	public void setLoweralarmact3(Integer loweralarmact3) {
		this.loweralarmact3 = loweralarmact3;
	}

	@Column(name = "UPPERALARMACT4")

	public Integer getUpperalarmact4() {
		return this.upperalarmact4;
	}

	public void setUpperalarmact4(Integer upperalarmact4) {
		this.upperalarmact4 = upperalarmact4;
	}

	@Column(name = "LOWERALARMAC4")

	public Integer getLoweralarmac4() {
		return this.loweralarmac4;
	}

	public void setLoweralarmac4(Integer loweralarmac4) {
		this.loweralarmac4 = loweralarmac4;
	}

}