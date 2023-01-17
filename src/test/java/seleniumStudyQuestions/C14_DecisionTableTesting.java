package seleniumStudyQuestions;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import unitilities.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C14_DecisionTableTesting {
    @Test
    public void decisionTableTesing() throws IOException {
//        //https://www.n11.com/ ' da
//        driver.get("https://www.n11.com/");
//
//        //Decision table testing yaparak tum olasiliklar icin login page'in bize verecegi responselari test edin.
//
//
//        //n11ValidEmail = test.123.yap@gmail.com
//
//        //n11ValidPassword = Deneme123!

        //WORKBOOD AC > SHEET > ROW > CELL

        String path = "./src/test/java/resources1/Decision_Table_Testing1.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(0);

        Cell cell = row.getCell(0);

        System.out.println(cell);







    }
}
