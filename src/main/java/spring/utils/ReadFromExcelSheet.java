package spring.utils;

import groovy.util.OrderBy;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
 import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Iterator;



public class ReadFromExcelSheet {

    public static void main(String[] args) {
        columnData();
    }

    public static void readAllCellData() {
        try
        {
            FileInputStream file = new FileInputStream(new File("src/main/resources/demo.xlsx"));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() );
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() );
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    // https://www.stackchief.com/blog/How%20to%20read%20a%20CSV%20file%20in%20Java%20%7C%20with%20examples

    public static void columnData() {
        try(
                BufferedReader br = new BufferedReader(new FileReader("src/main/resources/MOCK_DATA.csv"));
                CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(br);
        ) {
            for(CSVRecord record : parser) {
                System.out.println(record.get("first_name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // https://www.e-iceblue.com/Knowledgebase/Java/Spire.XLS-for-Java/Program-Guide/Data/Sort-Excel-Data-in-Java.html
    // https://dev.to/eiceblue/sort-data-in-excel-in-java-1cc3
/*

    public static void sortCells(){
        //Create a Workbook object
        try {
            Workbook workbook = new Workbook();

            //Load the sample Excel file
            workbook.loadFromFile("C:\\Users\\Administrator\\Desktop\\sample.xlsx");

            //Get the first worksheet
            Worksheet sheet = workbook.getWorksheets().get(0);

            //Specify the column index and the sort mode. The column index starts from 0.
            workbook.getDataSorter().getSortColumns().add(1, OrderBy.Ascending);

            //Specify the range to sort
            workbook.getDataSorter().sort(sheet.getCellRange("A1:F9"));

            //Save the document
            workbook.saveToFile("SortData.xlsx", ExcelVersion.Version2016);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void SortByValues() {

        //Create a Workbook instance
        Workbook workbook = new Workbook();
        //Load the Excel file
        workbook.loadFromFile("SortData.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create a sort column with the column index, the sort based on and order by attributes
        SortColumn column = workbook.getDataSorter().getSortColumns().add(0, SortComparsionType.Values, OrderBy.Descending);

        //Sort specified cell range
        workbook.getDataSorter().sort(sheet.getCellRange("A1:A8"));

        //Save the result file
        workbook.saveToFile("SortByValues.xlsx", ExcelVersion.Version2013);
    }
*/
}
