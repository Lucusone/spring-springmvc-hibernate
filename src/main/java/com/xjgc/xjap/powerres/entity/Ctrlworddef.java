package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ctrlworddef entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ctrlworddef", catalog = "e8000")

public class Ctrlworddef implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String bitmeaning1;
	private String bitmeaning2;
	private String bitmeaning3;
	private String bitmeaning4;
	private String bitmeaning5;
	private String bitmeaning6;
	private String bitmeaning7;
	private String bitmeaning8;
	private String bitmeaning9;
	private String bitmeaning10;
	private String bitmeaning11;
	private String bitmeaning12;
	private String bitmeaning13;
	private String bitmeaning14;
	private String bitmeaning15;
	private String bitmeaning16;

	// Constructors

	/** default constructor */
	public Ctrlworddef() {
	}

	/** minimal constructor */
	public Ctrlworddef(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Ctrlworddef(Integer id, String name, String bitmeaning1, String bitmeaning2, String bitmeaning3,
			String bitmeaning4, String bitmeaning5, String bitmeaning6, String bitmeaning7, String bitmeaning8,
			String bitmeaning9, String bitmeaning10, String bitmeaning11, String bitmeaning12, String bitmeaning13,
			String bitmeaning14, String bitmeaning15, String bitmeaning16) {
		this.id = id;
		this.name = name;
		this.bitmeaning1 = bitmeaning1;
		this.bitmeaning2 = bitmeaning2;
		this.bitmeaning3 = bitmeaning3;
		this.bitmeaning4 = bitmeaning4;
		this.bitmeaning5 = bitmeaning5;
		this.bitmeaning6 = bitmeaning6;
		this.bitmeaning7 = bitmeaning7;
		this.bitmeaning8 = bitmeaning8;
		this.bitmeaning9 = bitmeaning9;
		this.bitmeaning10 = bitmeaning10;
		this.bitmeaning11 = bitmeaning11;
		this.bitmeaning12 = bitmeaning12;
		this.bitmeaning13 = bitmeaning13;
		this.bitmeaning14 = bitmeaning14;
		this.bitmeaning15 = bitmeaning15;
		this.bitmeaning16 = bitmeaning16;
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

	@Column(name = "BITMEANING1", length = 128)

	public String getBitmeaning1() {
		return this.bitmeaning1;
	}

	public void setBitmeaning1(String bitmeaning1) {
		this.bitmeaning1 = bitmeaning1;
	}

	@Column(name = "BITMEANING2", length = 128)

	public String getBitmeaning2() {
		return this.bitmeaning2;
	}

	public void setBitmeaning2(String bitmeaning2) {
		this.bitmeaning2 = bitmeaning2;
	}

	@Column(name = "BITMEANING3", length = 128)

	public String getBitmeaning3() {
		return this.bitmeaning3;
	}

	public void setBitmeaning3(String bitmeaning3) {
		this.bitmeaning3 = bitmeaning3;
	}

	@Column(name = "BITMEANING4", length = 128)

	public String getBitmeaning4() {
		return this.bitmeaning4;
	}

	public void setBitmeaning4(String bitmeaning4) {
		this.bitmeaning4 = bitmeaning4;
	}

	@Column(name = "BITMEANING5", length = 128)

	public String getBitmeaning5() {
		return this.bitmeaning5;
	}

	public void setBitmeaning5(String bitmeaning5) {
		this.bitmeaning5 = bitmeaning5;
	}

	@Column(name = "BITMEANING6", length = 128)

	public String getBitmeaning6() {
		return this.bitmeaning6;
	}

	public void setBitmeaning6(String bitmeaning6) {
		this.bitmeaning6 = bitmeaning6;
	}

	@Column(name = "BITMEANING7", length = 128)

	public String getBitmeaning7() {
		return this.bitmeaning7;
	}

	public void setBitmeaning7(String bitmeaning7) {
		this.bitmeaning7 = bitmeaning7;
	}

	@Column(name = "BITMEANING8", length = 128)

	public String getBitmeaning8() {
		return this.bitmeaning8;
	}

	public void setBitmeaning8(String bitmeaning8) {
		this.bitmeaning8 = bitmeaning8;
	}

	@Column(name = "BITMEANING9", length = 128)

	public String getBitmeaning9() {
		return this.bitmeaning9;
	}

	public void setBitmeaning9(String bitmeaning9) {
		this.bitmeaning9 = bitmeaning9;
	}

	@Column(name = "BITMEANING10", length = 128)

	public String getBitmeaning10() {
		return this.bitmeaning10;
	}

	public void setBitmeaning10(String bitmeaning10) {
		this.bitmeaning10 = bitmeaning10;
	}

	@Column(name = "BITMEANING11", length = 128)

	public String getBitmeaning11() {
		return this.bitmeaning11;
	}

	public void setBitmeaning11(String bitmeaning11) {
		this.bitmeaning11 = bitmeaning11;
	}

	@Column(name = "BITMEANING12", length = 128)

	public String getBitmeaning12() {
		return this.bitmeaning12;
	}

	public void setBitmeaning12(String bitmeaning12) {
		this.bitmeaning12 = bitmeaning12;
	}

	@Column(name = "BITMEANING13", length = 128)

	public String getBitmeaning13() {
		return this.bitmeaning13;
	}

	public void setBitmeaning13(String bitmeaning13) {
		this.bitmeaning13 = bitmeaning13;
	}

	@Column(name = "BITMEANING14", length = 128)

	public String getBitmeaning14() {
		return this.bitmeaning14;
	}

	public void setBitmeaning14(String bitmeaning14) {
		this.bitmeaning14 = bitmeaning14;
	}

	@Column(name = "BITMEANING15", length = 128)

	public String getBitmeaning15() {
		return this.bitmeaning15;
	}

	public void setBitmeaning15(String bitmeaning15) {
		this.bitmeaning15 = bitmeaning15;
	}

	@Column(name = "BITMEANING16", length = 128)

	public String getBitmeaning16() {
		return this.bitmeaning16;
	}

	public void setBitmeaning16(String bitmeaning16) {
		this.bitmeaning16 = bitmeaning16;
	}

}