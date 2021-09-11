package com.demo.common;

import java.io.Serializable;

public class SalaryInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	String employeeName;

	String employeeEmail;

	Long salary;

	public SalaryInfo() {
	}

	public SalaryInfo(String employeeName, String employeeEmail) {
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
	}

	public SalaryInfo(String employeeName, String employeeEmail, Long salary) {
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.salary = salary;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeEmail == null) ? 0 : employeeEmail.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalaryInfo other = (SalaryInfo) obj;
		if (employeeEmail == null) {
			if (other.employeeEmail != null)
				return false;
		} else if (!employeeEmail.equals(other.employeeEmail))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalaryInfo [employeeName=").append(employeeName).append(", employeeEmail=")
				.append(employeeEmail).append(", salary=").append(salary).append("]");
		return builder.toString();
	}

}
