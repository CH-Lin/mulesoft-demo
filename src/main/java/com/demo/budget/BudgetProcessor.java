package com.demo.budget;

import com.demo.common.ReimbursementInfo;
import com.demo.common.SalaryInfo;
import com.google.gson.Gson;

public class BudgetProcessor {

	public static Long process(String salariesStr, String reimbursementsStr, String budgetStr) {
		Gson gson = new Gson();
		SalaryInfo[] salaries = gson.fromJson(salariesStr, SalaryInfo[].class);
		ReimbursementInfo[] reimbursements = gson.fromJson(reimbursementsStr, ReimbursementInfo[].class);
		/* Long budget = Long.parseLong(budgetStr); */

		long amount = 0;

		for (SalaryInfo info : salaries) {
			amount += (info.getSalary() * 12);
		}

		for (ReimbursementInfo info : reimbursements) {
			amount += (info.getAmount() * 10);
		}

		return amount /* - budget */;
	}

}
