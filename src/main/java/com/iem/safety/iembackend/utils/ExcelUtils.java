package com.iem.safety.iembackend.utils;

import com.iem.safety.iembackend.customer.Customer;
import com.iem.safety.iembackend.intensitysurvey.Intensitysurvey;
import com.iem.safety.iembackend.multisurvey.PartSurvey;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * excel utils
 *
 * @author MengQi 2018-06-15 16:14
 */
@SuppressWarnings({"unused", "unchecked"})
public class ExcelUtils {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private String rowNames[];
    private List<List<String>> rowDataList;
    private File file;
    private String sheetName;
    private XSSFWorkbook xssfWorkbook;

    public ExcelUtils(String[] rowNames, List<List<String>> rowDataList, File file, String sheetName) {
        this.rowNames = rowNames;
        this.rowDataList = rowDataList;
        this.file = file;
        this.sheetName = sheetName;
    }

    public ExcelUtils(File file) {
        this.file = file;
    }

    public XSSFWorkbook getXssfWorkbook() {
        return xssfWorkbook;
    }

    public void setXssfWorkbook(XSSFWorkbook xssfWorkbook) {
        this.xssfWorkbook = xssfWorkbook;
    }

    public List<List<String>> getRowDataList() {
        return rowDataList;
    }

    public void setRowDataList(List<List<String>> rowDataList) {
        this.rowDataList = rowDataList;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String[] getRowNames() {
        return rowNames;
    }

    public void setRowNames(String[] rowNames) {
        this.rowNames = rowNames;
    }


    public void create() throws IOException {
        //Create blank workbook
        xssfWorkbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet spreadsheet = xssfWorkbook.createSheet(sheetName);
        XSSFCellStyle cellStyle = xssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        XSSFFont font = xssfWorkbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);
        //Create row object
        int rowId = 0;
        XSSFRow row = spreadsheet.createRow(rowId++);

        for (int i = 0; i < rowNames.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(rowNames[i]);
            cell.setCellStyle(cellStyle);

        }


        XSSFCellStyle cellStyle_body = xssfWorkbook.createCellStyle();
        cellStyle_body.setAlignment(HorizontalAlignment.CENTER);
        cellStyle_body.setVerticalAlignment(VerticalAlignment.CENTER);


        for (List<String> stringList : rowDataList) {
            row = spreadsheet.createRow(rowId++);
            for (int i = 0; i < stringList.size(); i++) {
                XSSFCell cell = row.createCell(i);
                cell.setCellValue(stringList.get(i));
                cell.setCellStyle(cellStyle_body);
            }
        }


        this.writeAndClose();
    }

    public void MultiSurveyCreate(List<Map<String, Object>> mapList) throws IOException {
        //Create blank workbook
        xssfWorkbook = new XSSFWorkbook();
        XSSFCellStyle cellStyle = xssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        XSSFFont font = xssfWorkbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);
        //Create a blank sheet
        XSSFSheet spreadsheet = xssfWorkbook.createSheet(sheetName);
        spreadsheet.autoSizeColumn(1, true);
        //Create row object
        int rowId = 0;
        XSSFRow row = spreadsheet.createRow(rowId++);

        for (int i = 0; i < rowNames.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(rowNames[i]);
            cell.setCellStyle(cellStyle);
        }
        row = spreadsheet.createRow(rowId++);
        String[] rn = {"基本完好", "轻微破坏", "中等破坏", "严重破坏", "毁坏"};
        for (int i = 0; i < rowNames.length; i++) {
            XSSFCell cell = row.createCell(i);
            if (i < 10 || i > 14) {
                spreadsheet.addMergedRegion(new CellRangeAddress(0, 1, i, i));
            } else {
                cell.setCellValue(rn[i - 10]);
            }
            cell.setCellStyle(cellStyle);
        }
        spreadsheet.addMergedRegion(new CellRangeAddress(0, 0, 10, 14));

        XSSFCellStyle cellStyle_body = xssfWorkbook.createCellStyle();
        cellStyle_body.setAlignment(HorizontalAlignment.CENTER);
        cellStyle_body.setVerticalAlignment(VerticalAlignment.CENTER);


        for (Map<String, Object> map : mapList) {
            List<PartSurvey> parts = (List<PartSurvey>) map.get("part");
            Customer customer = (Customer) map.get("customer");
            Intensitysurvey intensitysurvey = (Intensitysurvey) map.get("intensitySurvey");
            for (PartSurvey part : parts) {
                row = spreadsheet.createRow(rowId++);
                row.createCell(0);
            }
        }


        this.writeAndClose();
    }


    public void createCustomerMultiSurvey() throws IOException {
        //Create blank workbook
        xssfWorkbook = new XSSFWorkbook();
        XSSFCellStyle cellStyle = xssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        XSSFFont font = xssfWorkbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);
        //Create a blank sheet
        XSSFSheet spreadsheet = xssfWorkbook.createSheet(sheetName);
        spreadsheet.autoSizeColumn(1, true);
        //Create row object
        int rowId = 0;
        XSSFRow row = spreadsheet.createRow(rowId++);
        for (int i = 0; i < rowNames.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(rowNames[i]);
            cell.setCellStyle(cellStyle);
        }
        row = spreadsheet.createRow(rowId++);
        String[] rn = {"基本完好", "轻微破坏", "中等破坏", "严重破坏", "毁坏"};
        for (int i = 0; i < rowNames.length; i++) {
            XSSFCell cell = row.createCell(i);
            if (i < 10 || i > 14) {
                spreadsheet.addMergedRegion(new CellRangeAddress(0, 1, i, i));
            } else {
                cell.setCellValue(rn[i - 10]);
            }
            cell.setCellStyle(cellStyle);
        }
        spreadsheet.addMergedRegion(new CellRangeAddress(0, 0, 10, 14));
        XSSFCellStyle cellStyle_body = xssfWorkbook.createCellStyle();
        cellStyle_body.setAlignment(HorizontalAlignment.CENTER);
        cellStyle_body.setVerticalAlignment(VerticalAlignment.CENTER);
        boolean flag;
        for (List<String> stringList : rowDataList) {
            row = spreadsheet.createRow(rowId++);
            flag = (rowId + 2) % 5 == 0;
            for (int i = 0; i < stringList.size(); i++) {
                XSSFCell cell = row.createCell(i);
                cell.setCellValue(stringList.get(i));
                cell.setCellStyle(cellStyle_body);
                if ((i < 9 || i > 16) && flag) {
                    spreadsheet.addMergedRegion(new CellRangeAddress(rowId - 1, rowId + 3, i, i));
                }

            }
        }


        this.writeAndClose();
    }


    private void writeAndClose() throws IOException {
        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(file);
        xssfWorkbook.write(out);
        out.flush();
        out.close();
        xssfWorkbook.close();
        logger.info(sheetName + " written successfully");
    }
}
