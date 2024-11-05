package Selenium_lab;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class UserDetails {
    public static void main(String[] args) {
        // Create a new workbook and a sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        // Header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("First_Name");
        headerRow.createCell(1).setCellValue("Last_Name");
        headerRow.createCell(2).setCellValue("E-Mail");
        headerRow.createCell(3).setCellValue("Telephone");
        headerRow.createCell(4).setCellValue("Password");
        headerRow.createCell(5).setCellValue("Password_Confirm");

        // Sample data rows
        Object[][] userData = {
            {"John", "Doe", "john.doe@example.com", "1234567890", "pass123", "pass123"},
            {"Jane", "Smith", "jane.smith@example.com", "0987654321", "pass456", "pass456"},
            {"Alice", "Brown", "alice.brown@example.com", "5555555555", "pass789", "pass789"}
        };

        int rowCount = 1;
        for (Object[] user : userData) {
            Row row = sheet.createRow(rowCount++);
            for (int i = 0; i < user.length; i++) {
                row.createCell(i).setCellValue(user[i].toString());
            }
        }

        // Write to an Excel file
        try (FileOutputStream fos = new FileOutputStream("UserDetails.xlsx")) {
            workbook.write(fos);
            System.out.println("UserDetails.xlsx created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}














