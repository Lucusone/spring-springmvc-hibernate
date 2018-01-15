package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * XmlpageId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class XmlpageId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer equipclassid;
	private Integer equipid;
	private String path1;
	private String path2;
	private String path3;

	// Constructors

	/** default constructor */
	public XmlpageId() {
	}

	/** full constructor */
	public XmlpageId(Integer id, Integer equipclassid, Integer equipid, String path1, String path2, String path3) {
		this.id = id;
		this.equipclassid = equipclassid;
		this.equipid = equipid;
		this.path1 = path1;
		this.path2 = path2;
		this.path3 = path3;
	}

	// Property accessors

	@Column(name = "id")

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "equipclassid")

	public Integer getEquipclassid() {
		return this.equipclassid;
	}

	public void setEquipclassid(Integer equipclassid) {
		this.equipclassid = equipclassid;
	}

	@Column(name = "equipid")

	public Integer getEquipid() {
		return this.equipid;
	}

	public void setEquipid(Integer equipid) {
		this.equipid = equipid;
	}

	@Column(name = "path1")

	public String getPath1() {
		return this.path1;
	}

	public void setPath1(String path1) {
		this.path1 = path1;
	}

	@Column(name = "path2")

	public String getPath2() {
		return this.path2;
	}

	public void setPath2(String path2) {
		this.path2 = path2;
	}

	@Column(name = "path3")

	public String getPath3() {
		return this.path3;
	}

	public void setPath3(String path3) {
		this.path3 = path3;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof XmlpageId))
			return false;
		XmlpageId castOther = (XmlpageId) other;

		return ((this.getId() == castOther.getId())
				|| (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
				&& ((this.getEquipclassid() == castOther.getEquipclassid())
						|| (this.getEquipclassid() != null && castOther.getEquipclassid() != null
								&& this.getEquipclassid().equals(castOther.getEquipclassid())))
				&& ((this.getEquipid() == castOther.getEquipid()) || (this.getEquipid() != null
						&& castOther.getEquipid() != null && this.getEquipid().equals(castOther.getEquipid())))
				&& ((this.getPath1() == castOther.getPath1()) || (this.getPath1() != null
						&& castOther.getPath1() != null && this.getPath1().equals(castOther.getPath1())))
				&& ((this.getPath2() == castOther.getPath2()) || (this.getPath2() != null
						&& castOther.getPath2() != null && this.getPath2().equals(castOther.getPath2())))
				&& ((this.getPath3() == castOther.getPath3()) || (this.getPath3() != null
						&& castOther.getPath3() != null && this.getPath3().equals(castOther.getPath3())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result + (getEquipclassid() == null ? 0 : this.getEquipclassid().hashCode());
		result = 37 * result + (getEquipid() == null ? 0 : this.getEquipid().hashCode());
		result = 37 * result + (getPath1() == null ? 0 : this.getPath1().hashCode());
		result = 37 * result + (getPath2() == null ? 0 : this.getPath2().hashCode());
		result = 37 * result + (getPath3() == null ? 0 : this.getPath3().hashCode());
		return result;
	}

}