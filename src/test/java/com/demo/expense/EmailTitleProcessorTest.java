package com.demo.expense;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailTitleProcessorTest {

	@Test
	void testProcess() {
		assertTrue(EmailProcessor.process("expense report"));
		assertTrue(EmailProcessor.process("invoice"));
		assertFalse(EmailProcessor.process(null));
		assertFalse(EmailProcessor.process("info"));
	}

}
