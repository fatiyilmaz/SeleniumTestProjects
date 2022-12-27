package pdfQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Syf27_Homework {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        Thread.sleep(3000);
        driver.get("https://www.facebook.com");
        String actualBaslik = driver.getTitle();
        if (actualBaslik.contains("facebook")){
            System.out.println("Sayfa basligi PASSED");
        }else{
            System.out.println("Sayfa basligi FAILED");
        }

        //2.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        //yazdirin.
        Thread.sleep(5000);
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains("facebook")){
            System.out.println("Sayfa url PASSED");
        }else{
            System.out.println("Sayfa url FAILED " +actualUrl);
        }

        //3.https://www.walmart.com/ sayfasina gidin.
        Thread.sleep(3000);
        driver.get("https://www.walmart.com");

        //4. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        Thread.sleep(3000);
        String actualSayfaBasligi = driver.getTitle();
        if (actualSayfaBasligi.contains("Walmart.com")){
            System.out.println("Sayfa basligi PASSED");
        }else{
            System.out.println("Sayfa basligi FAILED");
        }

        //5. Tekrar “facebook” sayfasina donun
        Thread.sleep(3000);
        driver.navigate().back();

        //6. Sayfayi yenileyin
        Thread.sleep(3000);
        driver.navigate().refresh();

        //7.Browser’i kapatin
        Thread.sleep(5000);
        driver.close();
    }
}

