package com.demo.expense;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ExpenseReportProcessor {

	public static ExpenseReportProcessResponse process(String filePath, String email) {

		ExpenseReportProcessResponse response = new ExpenseReportProcessResponse();

		if (filePath.startsWith("\"")) {
			filePath = filePath.substring(1);
		}
		if (filePath.endsWith("\"")) {
			filePath = filePath.substring(0, filePath.length() - 1);
		}

		try (FileInputStream file = new FileInputStream(new File(filePath));
				Workbook workbook = new XSSFWorkbook(file);) {

			Sheet sheet = workbook.getSheetAt(0);

			DataFormatter formatter = new DataFormatter(); // creating formatter using the default locale

			Cell cellOfEmployeeName = sheet.getRow(4).getCell(3);
			response.setName(formatter.formatCellValue(cellOfEmployeeName));
			ExpenseReportData report = new ExpenseReportData(formatter.formatCellValue(cellOfEmployeeName), email);
			response.setData(report);

			int currentRow = 8; // start from row 8 because the format of expense report is fixed
			while (true) {
				currentRow++;

				String dateStr = formatter.formatCellValue(sheet.getRow(currentRow).getCell(0));

				if (dateStr.equalsIgnoreCase("totals")) { // check end of expense items
					break;
				}

				String desc = formatter.formatCellValue(sheet.getRow(currentRow).getCell(3));

				Cell itemAmount = sheet.getRow(currentRow).getCell(11);
				String amountStr = itemAmount.toString();
				long amount = 0;
				if (!amountStr.isEmpty()) {
					FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
					CellValue cellValue = evaluator.evaluate(itemAmount);
					amount = (long) cellValue.getNumberValue();
				}

				if (!checkContent(response, dateStr, desc, amountStr, amount)) {
					continue;
				}

				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
				Date date = format.parse(dateStr);

				ExpenseReportItem item = new ExpenseReportItem();
				item.setTitle(desc);
				item.setDate(date);
				item.setAmount(amount);
				report.addExpenseReportItem(item);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			addErrorMsg(response, "Cannot find expense report file.");
		} catch (IOException e) {
			e.printStackTrace();
			addErrorMsg(response, "Cannot open expense report file.");
		} catch (ParseException e) {
			e.printStackTrace();
			addErrorMsg(response, "The date information is incorrect for some reimbursement item.");
		}
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		response.setJsonData(gson.toJson(response.getData()));

		return response;
	}

	private static boolean checkContent(ExpenseReportProcessResponse response, String date, String desc, String amount,
			long amountValue) {
		boolean status = true;
		if (date.isEmpty() && desc.isEmpty() && (amount.isEmpty() || amountValue == 0)) {
			if (amount.isEmpty() || amountValue == 0) { // Skip empty reimbursement item
				return false;
			}
			return status;
		}

		if (date.isEmpty()) {
			addErrorMsg(response, ExpenseReportProcessResponse.NO_DATE_FOR_ITEM);
			status = false;
		}

		if (desc.isEmpty()) {
			addErrorMsg(response, ExpenseReportProcessResponse.NO_DESC_FOR_ITEM);
			status = false;
		}

		if (amount.isEmpty() || amountValue <= 0) {
			addErrorMsg(response, ExpenseReportProcessResponse.VALUE_INCORRECT);
			status = false;
		}
		return status;
	}

	private static void addErrorMsg(ExpenseReportProcessResponse response, String msg) {
		response.setStatus(false);
		response.addErrMeg(msg);
	}

}
