package pdfQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Syf20_GetMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //2. Sayfa basligini(title) yazdirin
        String actualBaslik = driver.getTitle();

        //3. Sayfa basliginin “Amazon” icerdigini test edin
        if (actualBaslik.contains("Amazon")){
            System.out.println("Sayfa basligi PASSED");
        }else{
            System.out.println("Sayfa basligi FAILED");
        }

        //4. Sayfa adresini(url) yazdirin
        String actualUrl = driver.getCurrentUrl();

        //5. Sayfa url’inin “amazon” icerdigini test edin.
        if (actualUrl.contains("amazon")){
            System.out.println("Sayfa url PASSED");
        }else{
            System.out.println("Sayfa url FAILED");
        }

        //6. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

        //7. Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        String actualHtml = driver.getPageSource();
        if (actualHtml.contains("Gateway")){
            System.out.println("Sayfa html kodu PASSED");
        }else{
            System.out.println("Sayfa html kodu FAILED");
        }

        //8. Sayfayi kapatin
        driver.close();


    }
}

