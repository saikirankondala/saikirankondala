package util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class ExcelHelper {

    private final static String path = System.getProperty("user.dir")+"/src/excel/Inventory.xlsx";
    private  static XSSFWorkbook  workbook;

    public static void connectToExcelFile()
    {
        try {
            File file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getGeneralInformation ()
    {
        if(workbook==null) {
            connectToExcelFile();
        }
        XSSFSheet sheet = workbook.getSheetAt(0);
        for(int i=3;i<12;i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(5);
        switch (cell.getCellType())
        {
            case Cell.CELL_TYPE_STRING:
                System.out.print(cell.getStringCellValue() + "\t\t\t");
                break;
            case Cell.CELL_TYPE_NUMERIC:
                System.out.print(cell.getNumericCellValue() + "\t\t\t");
                break;
            default:
        }
        }
    }

    public static void main(String [] args) {
       getGeneralInformation();
    }
}
