package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dtransformertype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dtransformertype", catalog = "e8000")

public class Dtransformertype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String description;
	private Double ratedkVa;
	private Double noLoadLoss;
	private Double loadLoss;
	private Double excitingCurrent;
	private Integer ibaseVoltageId;
	private Double iratedkW;
	private Double iratedkV;
	private Double iloadLoss;
	private Double ileakageImpedence;
	private Integer jbaseVoltageId;
	private Double jratedkW;
	private Double jratedkV;
	private Double jloadLoss;
	private Double jleakageImpedence;

	// Constructors

	/** default constructor */
	public Dtransformertype() {
	}

	/** minimal constructor */
	public Dtransformertype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Dtransformertype(Integer id, String code, String name, String description, Double ratedkVa,
			Double noLoadLoss, Double loadLoss, Double excitingCurrent, Integer ibaseVoltageId, Double iratedkW,
			Double iratedkV, Double iloadLoss, Double ileakageImpedence, Integer jbaseVoltageId, Double jratedkW,
			Double jratedkV, Double jloadLoss, Double jleakageImpedence) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.ratedkVa = ratedkVa;
		this.noLoadLoss = noLoadLoss;
		this.loadLoss = loadLoss;
		this.excitingCurrent = excitingCurrent;
		this.ibaseVoltageId = ibaseVoltageId;
		this.iratedkW = iratedkW;
		this.iratedkV = iratedkV;
		this.iloadLoss = iloadLoss;
		this.ileakageImpedence = ileakageImpedence;
		this.jbaseVoltageId = jbaseVoltageId;
		this.jratedkW = jratedkW;
		this.jratedkV = jratedkV;
		this.jloadLoss = jloadLoss;
		this.jleakageImpedence = jleakageImpedence;
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

	@Column(name = "code", length = 16)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", length = 32)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 32)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "ratedkVA", precision = 22, scale = 0)

	public Double getRatedkVa() {
		return this.ratedkVa;
	}

	public void setRatedkVa(Double ratedkVa) {
		this.ratedkVa = ratedkVa;
	}

	@Column(name = "NoLoadLoss", precision = 22, scale = 0)

	public Double getNoLoadLoss() {
		return this.noLoadLoss;
	}

	public void setNoLoadLoss(Double noLoadLoss) {
		this.noLoadLoss = noLoadLoss;
	}

	@Column(name = "LoadLoss", precision = 22, scale = 0)

	public Double getLoadLoss() {
		return this.loadLoss;
	}

	public void setLoadLoss(Double loadLoss) {
		this.loadLoss = loadLoss;
	}

	@Column(name = "ExcitingCurrent", precision = 22, scale = 0)

	public Double getExcitingCurrent() {
		return this.excitingCurrent;
	}

	public void setExcitingCurrent(Double excitingCurrent) {
		this.excitingCurrent = excitingCurrent;
	}

	@Column(name = "iBaseVoltageID")

	public Integer getIbaseVoltageId() {
		return this.ibaseVoltageId;
	}

	public void setIbaseVoltageId(Integer ibaseVoltageId) {
		this.ibaseVoltageId = ibaseVoltageId;
	}

	@Column(name = "iRatedkW", precision = 22, scale = 0)

	public Double getIratedkW() {
		return this.iratedkW;
	}

	public void setIratedkW(Double iratedkW) {
		this.iratedkW = iratedkW;
	}

	@Column(name = "iRatedkV", precision = 22, scale = 0)

	public Double getIratedkV() {
		return this.iratedkV;
	}

	public void setIratedkV(Double iratedkV) {
		this.iratedkV = iratedkV;
	}

	@Column(name = "iLoadLoss", precision = 22, scale = 0)

	public Double getIloadLoss() {
		return this.iloadLoss;
	}

	public void setIloadLoss(Double iloadLoss) {
		this.iloadLoss = iloadLoss;
	}

	@Column(name = "iLeakageImpedence", precision = 22, scale = 0)

	public Double getIleakageImpedence() {
		return this.ileakageImpedence;
	}

	public void setIleakageImpedence(Double ileakageImpedence) {
		this.ileakageImpedence = ileakageImpedence;
	}

	@Column(name = "jBaseVoltageID")

	public Integer getJbaseVoltageId() {
		return this.jbaseVoltageId;
	}

	public void setJbaseVoltageId(Integer jbaseVoltageId) {
		this.jbaseVoltageId = jbaseVoltageId;
	}

	@Column(name = "jRatedkW", precision = 22, scale = 0)

	public Double getJratedkW() {
		return this.jratedkW;
	}

	public void setJratedkW(Double jratedkW) {
		this.jratedkW = jratedkW;
	}

	@Column(name = "jRatedkV", precision = 22, scale = 0)

	public Double getJratedkV() {
		return this.jratedkV;
	}

	public void setJratedkV(Double jratedkV) {
		this.jratedkV = jratedkV;
	}

	@Column(name = "jLoadLoss", precision = 22, scale = 0)

	public Double getJloadLoss() {
		return this.jloadLoss;
	}

	public void setJloadLoss(Double jloadLoss) {
		this.jloadLoss = jloadLoss;
	}

	@Column(name = "jLeakageImpedence", precision = 22, scale = 0)

	public Double getJleakageImpedence() {
		return this.jleakageImpedence;
	}

	public void setJleakageImpedence(Double jleakageImpedence) {
		this.jleakageImpedence = jleakageImpedence;
	}

}