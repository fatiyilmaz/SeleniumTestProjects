package pdfQuestions;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import unitilities.Main;

public class Calculator extends Main {


    @Test
    public void name() throws InterruptedException {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");


        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        Faker faker = new Faker();


        for (int i = 1; i < 3; i++) {
            String sayi = faker.number().digits(1);
            WebElement hesapMakine = driver.findElement(By.xpath("(//*[@class='keys']//span[@class='btn btn-outline-primary'])["+sayi+"]"));
            hesapMakine.click();
        }
        for (int i = 0; i < 1; i++) {
        int islem = faker.number().numberBetween(1,4);
        String yeniIslem = String.valueOf(islem);
        WebElement aciton = driver.findElement(By.xpath("(//span[@class='operator btn btn-outline-success'])["+yeniIslem+"]"));
        aciton.click();
    }
        for (int i = 1; i < 3; i++) {
            String sayi = faker.number().digits(1);
            WebElement hesapMakine = driver.findElement(By.xpath("(//*[@class='keys']//span[@class='btn btn-outline-primary'])["+sayi+"]"));
            hesapMakine.click();
        }
        WebElement sonuc = driver.findElement(By.xpath("//span[@class='btn btn-outline-warning']"));
        sonuc.click();
        waitFor(5);


        //Sonucu konsola yazdırıp
        System.out.println(driver.findElement(By.xpath("//*[@class='screen']")).getText());

        //Sonucun doğrulamasını yapalım

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='screen']")).isDisplayed());




    }
}
