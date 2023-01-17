package pdfQuestions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import unitilities.Main;

import java.util.List;

public class DenemeWebTables extends Main {

    @Test
    public void webTablesTest() {

        //Task 1 : Table1’i print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        String table2 = driver.findElement(By.xpath("//table[@id='table2']")).getText();
        System.out.println(table2);

        //body kismini parca parca alip yazdirir
        List<WebElement> bodyKismi = driver.findElements(By.xpath("//table[@id='table2']//tbody//td"));
        for (WebElement w: bodyKismi){
            System.out.println(w.getText());
        }



        //Task 2 : 3. Row’ datalarını print edin
        List<WebElement> ucSatir = driver.findElements(By.xpath("//table[@id='table2']//tbody//tr[3]//td"));
        for (WebElement w: ucSatir){
            System.out.println(w.getText());
        }


        //Task 3 : Son row daki dataları print edin
        String lastRow = driver.findElement(By.xpath("//table[@id='table2']//tbody//tr[last()]")).getText();
        System.out.println(lastRow);


        //Task 4 : 5. Column datalarini print edin
        List<WebElement> column = driver.findElements(By.xpath("//table[@id='table2']//tbody//tr//td[5]"));
        for (WebElement w: column){
            System.out.println(w.getText());
        }

        printData(2,3);//fbach@yahoo.com
        printData(3,5);//http://www.jdoe.com

        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData


        //Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin

    }
    public void printData(int row, int column){
        driver.get("https://the-internet.herokuapp.com/tables");
        String yazdir = "//table[@id='table2']//tbody//tr["+row+"]//td["+column+"]";
        System.out.println(driver.findElement(By.xpath(yazdir)).getText());

    }

}
