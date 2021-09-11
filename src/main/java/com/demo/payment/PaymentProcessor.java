package com.demo.payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.common.ReimbursementInfo;
import com.demo.common.SalaryInfo;
import com.google.gson.Gson;

public class PaymentProcessor {

	public static List<PaymentRequestData> process(String salariesStr, String reimbursementsStr, Integer year,
			Integer month) {
		Gson gson = new Gson();
		SalaryInfo[] salaries = gson.fromJson(salariesStr, SalaryInfo[].class);
		ReimbursementInfo[] reimbursements = gson.fromJson(reimbursementsStr, ReimbursementInfo[].class);
		List<PaymentRequestData> result = new ArrayList<>();

		Map<SalaryInfo, Long> salaryMap = new HashMap<>();
		Map<SalaryInfo, PaymentRequestData> paymentMap = new HashMap<>();

		for (SalaryInfo info : salaries) {
			salaryMap.put(info, info.getSalary());
			paymentMap.put(info, new PaymentRequestData(year, month, info.getEmployeeName(), info.getEmployeeEmail(),
					info.getSalary()));
		}

		for (ReimbursementInfo info : reimbursements) {
			SalaryInfo temp = new SalaryInfo(info.getEmployeeName(), info.getEmployeeEmail());
			PaymentRequestData data = paymentMap.get(temp);
			data.setAmount(data.getAmount() + info.getAmount());
			paymentMap.put(temp, data);
		}

		for (SalaryInfo info : salaries) {
			result.add(paymentMap.get(info));
		}

		return result;
	}

}
