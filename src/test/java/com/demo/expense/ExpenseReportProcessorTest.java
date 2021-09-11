package com.demo.expense;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ExpenseReportProcessorTest {

	@Test
	void testProcessGoodReports() {
		ExpenseReportProcessResponse response = ExpenseReportProcessor
				.process("src/test/resources/Expense Report 1.xlsx", "test@company.com");
		assertTrue(response.isStatus());
		assertNull(response.getMsg());
		assertEquals(2, response.getData().getItems().size());
		assertEquals(6000, response.getData().getItems().get(0).getAmount());
		assertEquals(1400, response.getData().getItems().get(1).getAmount());

		ExpenseReportProcessResponse response2 = ExpenseReportProcessor
				.process("src/test/resources/Expense Report 2.xlsx", "test@company.com");
		assertTrue(response2.isStatus());
		assertNull(response2.getMsg());
		assertEquals(2, response2.getData().getItems().size());
		assertEquals(6000, response2.getData().getItems().get(0).getAmount());
		assertEquals(1400, response2.getData().getItems().get(1).getAmount());

		ExpenseReportProcessResponse response3 = ExpenseReportProcessor
				.process("src/test/resources/Expense Report 3.xlsx", "test@company.com");
		assertTrue(response3.isStatus());
		assertNull(response3.getMsg());
		assertEquals(2, response3.getData().getItems().size());
		assertEquals(6000, response3.getData().getItems().get(0).getAmount());
		assertEquals(1400, response3.getData().getItems().get(1).getAmount());
	}

	@Test
	void testProcessBadReports() {
		ExpenseReportProcessResponse response = ExpenseReportProcessor
				.process("src/test/resources/Expense Report with error 1.xlsx", "test@company.com");
		assertFalse(response.isStatus());
		assertEquals(1, response.getMsg().size());
		assertTrue(ExpenseReportProcessResponse.NO_DESC_FOR_ITEM.equals(response.getMsg().get(0)));

		ExpenseReportProcessResponse response2 = ExpenseReportProcessor
				.process("src/test/resources/Expense Report with error 2.xlsx", "test@company.com");
		assertFalse(response2.isStatus());
		assertEquals(1, response2.getMsg().size());
		assertTrue(ExpenseReportProcessResponse.VALUE_INCORRECT.equals(response2.getMsg().get(0)));

		ExpenseReportProcessResponse response3 = ExpenseReportProcessor
				.process("src/test/resources/Expense Report with error 3.xlsx", "test@company.com");
		assertFalse(response3.isStatus());
		assertEquals(1, response3.getMsg().size());
		assertTrue(ExpenseReportProcessResponse.NO_DATE_FOR_ITEM.equals(response3.getMsg().get(0)));

		ExpenseReportProcessResponse response4 = ExpenseReportProcessor
				.process("src/test/resources/Expense Report with error 4.xlsx", "test@company.com");
		assertFalse(response4.isStatus());
		assertEquals(2, response4.getMsg().size());
		assertTrue(ExpenseReportProcessResponse.NO_DATE_FOR_ITEM.equals(response4.getMsg().get(0)));
		assertTrue(ExpenseReportProcessResponse.VALUE_INCORRECT.equals(response4.getMsg().get(1)));
	}

}
