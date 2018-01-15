package com.xjgc.xjap.powerres.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Acurvelimit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "acurvelimit", catalog = "e8000")

public class Acurvelimit implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer alimittypeid;
	private Integer seqno;
	private Date starttime;
	private Date endtime;
	private Double uppervalue;
	private Double lowervalue;

	// Constructors

	/** default constructor */
	public Acurvelimit() {
	}

	/** minimal constructor */
	public Acurvelimit(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Acurvelimit(Integer id, Integer alimittypeid, Integer seqno, Date starttime, Date endtime, Double uppervalue,
			Double lowervalue) {
		this.id = id;
		this.alimittypeid = alimittypeid;
		this.seqno = seqno;
		this.starttime = starttime;
		this.endtime = endtime;
		this.uppervalue = uppervalue;
		this.lowervalue = lowervalue;
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

	@Column(name = "ALIMITTYPEID")

	public Integer getAlimittypeid() {
		return this.alimittypeid;
	}

	public void setAlimittypeid(Integer alimittypeid) {
		this.alimittypeid = alimittypeid;
	}

	@Column(name = "SEQNO")

	public Integer getSeqno() {
		return this.seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTTIME", length = 10)

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ENDTIME", length = 10)

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
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

}