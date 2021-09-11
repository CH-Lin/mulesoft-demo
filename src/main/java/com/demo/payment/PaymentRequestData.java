package com.demo.payment;

import java.io.Serializable;

public class PaymentRequestData implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer year;

	private Integer month;

	private String employeeName;

	private String employeeEmail;

	private Long amount;

	public PaymentRequestData() {
	}

	public PaymentRequestData(Integer year, Integer month, String employeeName, String employeeEmail, Long amount) {
		this.year = year;
		this.month = month;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.amount = amount;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentRequestData [year=").append(year).append(", month=").append(month)
				.append(", employeeName=").append(employeeName).append(", employeeEmail=").append(employeeEmail)
				.append(", amount=").append(amount).append("]");
		return builder.toString();
	}

}
