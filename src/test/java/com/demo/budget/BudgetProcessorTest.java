package com.demo.budget;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BudgetProcessorTest {

	@Test
	void test() {
		String salariesStr = "[{\"employeeName\":\"John\",\"employeeEmail\":\"john@company.com\",\"salary\":1200000},{\"employeeName\":\"Emma\",\"employeeEmail\":\"emma@company.com\",\"salary\":1200000}]";
		String reimbursementsStr = "[{\"year\":2021,\"month\":8,\"employeeName\":\"Emma\",\"employeeEmail\":\"emma@company.com\",\"amount\":2100},{\"year\":2021,\"month\":8,\"employeeName\":\"Emma\",\"employeeEmail\":\"emma@company.com\",\"amount\":5210},{\"year\":2021,\"month\":8,\"employeeName\":\"John\",\"employeeEmail\":\"john@company.com\",\"amount\":2000},{\"year\":2021,\"month\":8,\"employeeName\":\"Emma\",\"employeeEmail\":\"emma@company.com\",\"amount\":3500}]";
		long result = BudgetProcessor.process(salariesStr, reimbursementsStr, "1");
		assertEquals(28812809, result);
	}

}
