package com.demo.expense;

import java.io.Serializable;
import java.util.Date;

public class ExpenseReportItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;

	private Date date;

	private long amount;

	public ExpenseReportItem() {
	}

	public ExpenseReportItem(String title, Date date, long amount) {
		this.title = title;
		this.date = date;
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExpenseReportItem [title=").append(title).append(", date=").append(date).append(", amount=")
				.append(amount).append("]");
		return builder.toString();
	}

}
