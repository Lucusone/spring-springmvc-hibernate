package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Periodtype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "periodtype", catalog = "e8000")

public class Periodtype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer count;
	private Float pricechong;
	private Float pricefang;
	private Float usepowprice;
	private Float genpowprice;

	// Constructors

	/** default constructor */
	public Periodtype() {
	}

	/** minimal constructor */
	public Periodtype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Periodtype(Integer id, String name, Integer count, Float pricechong, Float pricefang, Float usepowprice,
			Float genpowprice) {
		this.id = id;
		this.name = name;
		this.count = count;
		this.pricechong = pricechong;
		this.pricefang = pricefang;
		this.usepowprice = usepowprice;
		this.genpowprice = genpowprice;
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

	@Column(name = "COUNT")

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "PRICECHONG", precision = 4)

	public Float getPricechong() {
		return this.pricechong;
	}

	public void setPricechong(Float pricechong) {
		this.pricechong = pricechong;
	}

	@Column(name = "PRICEFANG", precision = 4)

	public Float getPricefang() {
		return this.pricefang;
	}

	public void setPricefang(Float pricefang) {
		this.pricefang = pricefang;
	}

	@Column(name = "USEPOWPRICE", precision = 8)

	public Float getUsepowprice() {
		return this.usepowprice;
	}

	public void setUsepowprice(Float usepowprice) {
		this.usepowprice = usepowprice;
	}

	@Column(name = "GENPOWPRICE", precision = 8)

	public Float getGenpowprice() {
		return this.genpowprice;
	}

	public void setGenpowprice(Float genpowprice) {
		this.genpowprice = genpowprice;
	}

}