package DataDriven;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;
 
public class ExcelApiTest
{
   public FileInputStream fis = null;
   public XSSFWorkbook workbook = null;
   public XSSFSheet sheet = null;
   public XSSFRow row = null;
   public XSSFCell cell = null;
   String xlFilePath;
 
   public ExcelApiTest(String xlFilePath) throws Exception
   {
       this.xlFilePath = xlFilePath;
       fis = new FileInputStream(xlFilePath);
       workbook = new XSSFWorkbook(fis);
       fis.close();
   }
 
   public int getRowCount(String sheetName)
   {
       sheet = workbook.getSheet(sheetName);
       int rowCount = sheet.getLastRowNum()+1;
       return rowCount;
   }
 
   public int getColumnCount(String sheetName)
   {
       sheet = workbook.getSheet(sheetName);
       row = sheet.getRow(0);
       int colCount = row.getLastCellNum();
       return colCount;
   }
   
   public static void main(String[] args) throws Exception
   {
       ExcelApiTest eat = new ExcelApiTest("C:\\Users\\Qapitol\\Documents\\Automation Exercise\\User Credentials.xlsx");
       int colCount = eat.getColumnCount("Credentials");
       System.out.println("Total Columns in the Excel : "+colCount);
       int rowCount = eat.getRowCount("Credentials");
       System.out.println("Total Rows in the Excel : "+rowCount);
   }
}