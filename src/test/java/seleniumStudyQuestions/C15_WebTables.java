package seleniumStudyQuestions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import unitilities.Main;

import java.util.List;

public class C15_WebTables extends Main {
    @Test
    public void webTablesTest() {

     //https://www.way2automation.com/angularjs-protractor/webtables/
    driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");


    //tüm E-mail leri yazdırın

    //Tüm E-maillerin "@" işareti içerdiğini doğrulayin

        List<WebElement> list=driver.findElements(By.xpath("//table[@class='smart-table table table-striped']//tbody//td[7]"));
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).getText());
            Assert.assertTrue(list.get(i).getText().contains("@"));
        }

    }

}
