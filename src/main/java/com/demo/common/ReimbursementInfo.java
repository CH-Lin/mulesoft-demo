package com.demo.common;

import java.io.Serializable;

public class ReimbursementInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	int year;

	int month;

	String employeeName;

	String employeeEmail;

	long amount;

	public ReimbursementInfo() {
	}

	public ReimbursementInfo(int year, int month, String employeeName, String employeeEmail, long amount) {
		this.year = year;
		this.month = month;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.amount = amount;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
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

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
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
		ReimbursementInfo other = (ReimbursementInfo) obj;
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
		builder.append("ReimbursementInfo [year=").append(year).append(", month=").append(month)
				.append(", employeeName=").append(employeeName).append(", employeeEmail=").append(employeeEmail)
				.append(", amount=").append(amount).append("]");
		return builder.toString();
	}

}
