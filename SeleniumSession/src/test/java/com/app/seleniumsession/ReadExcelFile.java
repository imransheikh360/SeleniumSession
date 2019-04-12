package com.app.seleniumsession;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.*;

public class ReadExcelFile {

	public void readRow(int rowNumber, int columnNumber) throws IOException {
		//XSSFWorkbook workbook = null;
		Workbook workbook = null;
		try {
			//String filePath = "E:\\AutomationWorkSpace\\SeleniumJava\\JavaTestProject\\Files\\CredentialSheet.xlsx";
			String filePath = "F:\\AutomationWorkspace\\SeleniumSession\\Files\\CredentialSheet11.xls";

			FileInputStream file = new FileInputStream(filePath);

			//workbook = new XSSFWorkbook(file);
			workbook= WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheetAt(0);
			//Sheet sheet = workbook.getSheet("CredentialSheet");

			Iterator<Row> rows = sheet.iterator();

			while (rows.hasNext()) {

				Row currentRow = rows.next();
				Iterator<Cell> col = currentRow.iterator();

				while (col.hasNext()) {
					System.out.println(col.next());
				}
			}
		} catch (Exception e) {
			workbook.close();
		}

	}

	public static void main(String[] args) throws IOException {

		ReadExcelFile readexcel = new ReadExcelFile();
		readexcel.readRow(2, 5);
	}

}
