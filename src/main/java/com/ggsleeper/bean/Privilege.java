package com.ggsleeper.bean;

// Generated 2017-5-23 15:20:22 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Privilege generated by hbm2java
 */
@Entity
@Table(name = "tbl_privilege", catalog = "carmanager")
public class Privilege implements java.io.Serializable {

	private Integer priId;
	private String priName;
	private String priDesc;
	private String priType;

	public Privilege() {
	}

	public Privilege(String priName, String priDesc, String priType) {
		this.priName = priName;
		this.priDesc = priDesc;
		this.priType = priType;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PRI_ID", unique = true, nullable = false)
	public Integer getPriId() {
		return this.priId;
	}

	public void setPriId(Integer priId) {
		this.priId = priId;
	}

	@Column(name = "PRI_NAME")
	public String getPriName() {
		return this.priName;
	}

	public void setPriName(String priName) {
		this.priName = priName;
	}

	@Column(name = "PRI_DESC")
	public String getPriDesc() {
		return this.priDesc;
	}

	public void setPriDesc(String priDesc) {
		this.priDesc = priDesc;
	}

	@Column(name = "PRI_TYPE")
	public String getPriType() {
		return this.priType;
	}

	public void setPriType(String priType) {
		this.priType = priType;
	}

}
