package com.demo.expense;

public class EmailProcessor {

	public static boolean process(String title) {
		// TO-DO, fuzzy inference or classification with Spark because not everyone put
		// correct title on email for expense report
		return title != null && ((title.toLowerCase().indexOf("expense report") >= 0)
				|| (title.toLowerCase().indexOf("invoice") >= 0));
	}

}
