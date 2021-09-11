package com.demo.expense;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExpenseReportData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String email;

	private List<ExpenseReportItem> items;

	public ExpenseReportData() {
	}

	public ExpenseReportData(String name, String email) {
		this.name = name;
		this.email = email;
		this.items = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ExpenseReportItem> getItems() {
		return items;
	}

	public void setItems(List<ExpenseReportItem> items) {
		this.items = items;
	}

	public void addExpenseReportItem(ExpenseReportItem item) {
		this.items.add(item);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExpenseReportData [name=").append(name).append(", email=").append(email).append(", items=")
				.append(items).append("]");
		return builder.toString();
	}

}
