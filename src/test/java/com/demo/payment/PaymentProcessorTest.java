package com.demo.payment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class PaymentProcessorTest {

	@Test
	void testProcess() {
		String salariesStr = "[{\"employeeName\":\"John\",\"employeeEmail\":\"john@company.com\",\"salary\":1200000},{\"employeeName\":\"Emma\",\"employeeEmail\":\"emma@company.com\",\"salary\":1200000}]";
		String reimbursementsStr = "[{\"year\":2021,\"month\":8,\"employeeName\":\"Emma\",\"employeeEmail\":\"emma@company.com\",\"amount\":2100},{\"year\":2021,\"month\":8,\"employeeName\":\"Emma\",\"employeeEmail\":\"emma@company.com\",\"amount\":5210},{\"year\":2021,\"month\":8,\"employeeName\":\"John\",\"employeeEmail\":\"john@company.com\",\"amount\":2000},{\"year\":2021,\"month\":8,\"employeeName\":\"Emma\",\"employeeEmail\":\"emma@company.com\",\"amount\":3500}]";
		List<PaymentRequestData> result = PaymentProcessor.process(salariesStr, reimbursementsStr, 2021, 8);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		System.out.println(gson.toJson(result));
		assertEquals(2, result.size());
		assertEquals(1202000, result.get(0).getAmount());
		assertEquals(1210810, result.get(1).getAmount());
	}

}
