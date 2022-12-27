package seleniumStudyQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_AramaCubuguTesti {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown(){
        //driver.close();
    }

    @Test
    public void test01(){

//        1-https://books-pwakit.appspot.com/ adresine gidin.
        driver.get("https://books-pwakit.appspot.com/");

//        2-"BOOKS" başlığının görünür olduğunu doğrulayın
        WebElement actualTitle = driver.findElement(By.xpath("//*[text()='BOOKS']"));
        if (actualTitle.isDisplayed()){
            System.out.println("Baslik PASSED");
        }else{
            System.out.println("Baslik FAILED");
        }

//        3-Arama çubuğunda "Selenium" u aratın.
//        WebElement books = driver.findElement(By.xpath("//*[text()='BOOKS']"));
//        WebElement seleniumArat =driver.findElement(with(By.tagName("div")).below(books));
//        seleniumArat.click();




//        4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.







    }





}
