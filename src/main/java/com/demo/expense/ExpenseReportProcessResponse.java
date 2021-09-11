package com.demo.expense;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExpenseReportProcessResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String NO_DATE_FOR_ITEM = "There is no date for some reimbursement item in your expense report.";

	public static final String NO_DESC_FOR_ITEM = "There is no description for some reimbursement item in your expense report.";

	public static final String VALUE_INCORRECT = "The value of TOTALS for some reimbursement item is incorrect in your expense report.";

	private boolean status = true;

	private String name;

	private List<String> msg;

	private ExpenseReportData data;

	private String jsonData;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMsg() {
		return msg;
	}

	public void setMsg(List<String> msg) {
		this.msg = msg;
	}

	public void addErrMeg(String msg) {
		if (this.msg == null) {
			this.msg = new ArrayList<>();
		}
		this.msg.add(msg);
	}

	public ExpenseReportData getData() {
		return data;
	}

	public void setData(ExpenseReportData data) {
		this.data = data;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExpenseReportProcessResponse [status=").append(status).append(", name=").append(name)
				.append(", msg=").append(msg).append(", data=").append(data).append(", jsonData=").append(jsonData)
				.append("]");
		return builder.toString();
	}

}
