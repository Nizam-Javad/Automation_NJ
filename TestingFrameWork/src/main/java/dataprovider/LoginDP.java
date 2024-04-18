package dataprovider;

import constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class LoginDP {
    private LoginDP(){}
    @DataProvider(name="loginDP")
    public static Object [][] loginDP() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\TestingFramework1\\Automation_NJ\\TestingFrameWork\\src\\main\\java\\resources\\suiteDataProvider.xlsx");
                //(FrameworkConstants.getReferencePath() + "\\" + "src\\main\\java\\resources\\suiteDataProvider.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();
        //System.out.println("Printing the sheet hardcoded : "+sheet.getRow(1).getCell(0).getStringCellValue());
        Object[][] obj = new Object[rowCount][columnCount];
        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                //System.out.println("Printing the sheet hardcoded Inside for loop: "+sheet.getRow(1).getCell(0).getStringCellValue());
                obj[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                /*obj[0][0] = sheet.getRow(0).getCell(0).getStringCellValue();
                obj[0][1] = sheet.getRow(0).getCell(1).getStringCellValue();
                obj[1][0] = sheet.getRow(1).getCell(0).getStringCellValue();
                obj[1][1] = sheet.getRow(1).getCell(1).getStringCellValue();*/

            }
        }
        return obj;
    }
    }


