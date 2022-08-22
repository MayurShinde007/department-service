package com.ci.departmentservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "deptId")
	private Long deptId;

	@NotNull
	@Column(name = "deptName")
	private String deptName;

	@NotNull
	@Column(name = "deptAddress")
	private String deptAddress;

	public Department() {
	}

	public Department(Long deptId, String deptName, String deptAddress) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptAddress = deptAddress;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptAddress() {
		return deptAddress;
	}

	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptAddress=" + deptAddress + "]";
	}

}
