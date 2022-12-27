package pdfQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Syf28_TekrarTesti {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        String actualTitle= driver.getTitle();
        if (actualTitle.contains("youtube")){
            System.out.println("Sayfa basligi PASSED");
        }else{
            System.out.println("Sayfa basligi FAILED "+actualTitle);
        }

        //2. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
        //doğru URL'yi yazdırın.
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains("youtube")){
            System.out.println("Sayfa url si PASSED");
        }else{
            System.out.println("Sayfa url si FAILED "+actualUrl);
        }

        //3. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //4. Youtube sayfasina geri donun
        driver.navigate().back();

        //5. Sayfayi yenileyin
        driver.navigate().refresh();

        //6. Amazon sayfasina donun
        driver.navigate().forward();

        //7. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();

        //8. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //Yoksa doğru başlığı(Actual Title) yazdırın.
        //9.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        //URL'yi yazdırın
        //10.Sayfayi kapatin



    }
}

