package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Case05_KullaniciMevcutEpostaKaydet {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
     */

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
        @Test
    public void test(){
            //1. Tarayıcıyı başlatın
            //2. 'http://automationexercise.com' URL'sine gidin
            driver.get("http://automationexercise.com");

            //3. Ana sayfanın başarıyla göründüğünü doğrulayın
            WebElement AnasayfaGorunuyorMu = driver.findElement(By.xpath("//*[@lang='en']"));
            Assert.assertTrue(AnasayfaGorunuyorMu.isDisplayed());

            //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
            driver.findElement(By.xpath("//*[@href='/login']")).click();

            //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
            WebElement kullaniciKaydiDogrulama = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
            Assert.assertTrue(kullaniciKaydiDogrulama.isDisplayed());

            //6. Adı ve kayıtlı e-posta adresini girin
            driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Jorge", Keys.TAB,"asdzF123@gmail.com");

            //7. 'Kaydol' düğmesini tıklayın
            driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

            //8. 'E-posta Adresi zaten mevcut!' hatasını doğrulayın. görünür
            WebElement ePostaMevcut = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
            Assert.assertTrue(ePostaMevcut.isDisplayed());
        }

}
