package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Case07_TestSeneryoDogrula {


    //1. Tarayıcıyı başlatın
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test() throws InterruptedException {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anasayfaGozukuyorMu = driver.findElement(By.xpath("//*[@lang='en']"));
        Assert.assertTrue(anasayfaGozukuyorMu.isDisplayed());
        driver.navigate().to("https://automationexercise.com/test_cases");





        //4. 'Test Durumları' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[@href='/test_cases'])[1]")).click();

        //5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın
        WebElement testSeneryoGozukuyorMu = driver.findElement(By.xpath("//*[@style='color: red;']"));
        Assert.assertTrue(testSeneryoGozukuyorMu.isDisplayed());

    }

    @After
    public void tearDown(){
        //driver.close();
    }

}
