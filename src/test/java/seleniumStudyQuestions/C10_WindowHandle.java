package seleniumStudyQuestions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import unitilities.Main;

import java.util.Set;

public class C10_WindowHandle extends Main {
    @Test
    public void windowHandle() throws InterruptedException {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");


        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//*[@class='card-body'])[3]")).click();
        Thread.sleep(3000);


        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        String actualResult = driver.findElement(By.xpath("//div[.='Please select an item from left to start practice.']")).getText();
        String expectedResult = "Please select an item from left to start practice.";
        Assert.assertEquals(expectedResult,actualResult);



        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//span[.='Browser Windows']")).click();


        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newTab.isDisplayed());


        //New Tab butonuna click yap
        newTab.click();


        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula

        String window1handle = driver.getWindowHandle();

        Set<String> gecis = driver.getWindowHandles();
        for (String w: gecis){
            if (!w.equals(window1handle)){
                driver.switchTo().window(w);
            }
        }

        String textResult = driver.findElement(By.xpath("//*[@id='sampleHeading']")).getText();
        String textResult1 = "This is a sample page";
        Assert.assertTrue(textResult.contains(textResult1));


        //İlk Tab'a geri dön
        driver.switchTo().window(window1handle);


        //New Tab butonunun görünür olduğunu doğrula
//        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
//        Assert.assertTrue(newTab.isDisplayed());

        Assert.assertTrue(newTab.isDisplayed());

        Thread.sleep(3000);
    }





    }



