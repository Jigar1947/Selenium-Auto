package MyPractice;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingDataFromExcel {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Test Allo(1).xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        // get Desired sheet
        XSSFSheet sheet = workbook.getSheet("Tests sheet");

        //get total rows
        int TotalRows = sheet.getLastRowNum();

        //get total cells
        int TotalCells = sheet.getRow(1).getLastCellNum();

        // Now lets print out Data
        for(int r =0;r<=TotalRows;r++){
            XSSFRow currentRow = sheet.getRow(r);
            for(int c = 0;c<TotalCells;c++){
                XSSFCell currentCell = currentRow.getCell(c);
                System.out.print(currentCell.toString()+"\t");
            }
            System.out.println();
        }

        workbook.close();
        file.close();



    }
}
