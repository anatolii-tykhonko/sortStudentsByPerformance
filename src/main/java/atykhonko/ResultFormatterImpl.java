package atykhonko;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Map;

public class ResultFormatterImpl implements ResultFormatter {
    @Override
    public String printResult(String[] result) {
        int maxLengthName = 0;
        for (int i = 0; i < result.length; i++) {
            int lengthName = result[i].split(",")[0].length();
            if (lengthName > maxLengthName) {
                maxLengthName = lengthName;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            builder.append(formatLineResult(result[i], i + 1, getCountsOfDigits(result.length), maxLengthName));
        }
        return builder.toString();
    }

    private String formatLineResult(String s, int position, long quantityRecords, int sizeName) {
        String[] temp = s.split(",");
        String formatPosition = "%" + quantityRecords + "." + quantityRecords + "s|";
        StringBuilder builder = new StringBuilder(formatPosition);
        String formatName = "%-" + sizeName + "." + sizeName + "s" + " |";
        String formatMark = "%s|" + "%n";
        builder.append(formatName).append(formatMark);
        return String.format(builder.toString(), position, temp[0], temp[1]);
    }

    private int getCountsOfDigits(long number) {
        return String.valueOf(Math.abs(number)).length();
    }


    @Override
    public void saveResultToFile(String[] result, String pathToSaveFile) {
        String nameStudent = "Full name student";
        String performance = "Average Mark";
        Map<String, String> mapEntry = Mapper.convertToMap(result);
        try {
            Workbook writeBook = new XSSFWorkbook();
            Sheet sheet = writeBook.createSheet();

            int rowCount = 0;
            Row row = sheet.createRow(rowCount);
            Cell cell = row.createCell(0);
            cell.setCellValue("№");
            row.createCell(1).setCellValue(nameStudent);
            row.createCell(2).setCellValue(performance);

            int index = 0;

            for (Map.Entry<String, String> entity : mapEntry.entrySet()) {
                row = sheet.createRow(++rowCount);
                cell = row.createCell(0);
                cell.setCellValue(++index);
                row.createCell(1).setCellValue(entity.getKey());
                row.createCell(2).setCellValue(entity.getValue());
            }

            writeBook.write(new FileOutputStream(pathToSaveFile, false));
            writeBook.close();
        } catch (Exception e) {
            throw new RuntimeException("fail to import data to XLSX file: " + e.getMessage());
        }
    }
}
