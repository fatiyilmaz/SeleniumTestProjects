package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Case08_TumUrunlerVeSyfDogrula {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. The products list is visible
    //7. Click on 'View Product' of first product
    //8. User is landed to product detail page
    //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        //1. Tarayıcıyı başlatın
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");


        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anasayfaDogrulama = driver.findElement(By.xpath("//*[@lang='en']"));
        Assert.assertTrue(anasayfaDogrulama.isDisplayed());


        //4. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        driver.navigate().refresh();
        driver.navigate().to("https://automationexercise.com/products");


        //5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        WebElement urunlerSyfsiMiDogrula = driver.findElement(By.xpath("//*[text()='All Products']"));
        Assert.assertTrue(urunlerSyfsiMiDogrula.isDisplayed());


        //6. Ürün listesi görünür
        WebElement urunListesiGorunurMu = driver.findElement(By.xpath("//*[@class='features_items']"));
        Assert.assertTrue(urunListesiGorunurMu.isDisplayed());


        //7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        WebElement urunGoruntule = driver.findElement(By.xpath("//*[@href='/product_details/1']"));
        urunGoruntule.sendKeys(Keys.ENTER);


        //8. Kullanıcı ürün detay sayfasına yönlendirildi
        WebElement urunDetaySayfasi = driver.findElement(By.xpath("//*[@class='col-sm-7']"));
        Assert.assertTrue(urunDetaySayfasi.isDisplayed());


        //9. Ürün adı, kategorisi, fiyatı, bulunabilirliği, durumu, markası gibi ayrıntıların göründüğünü doğrulayın
        WebElement urunAyrintiSayfasi = driver.findElement(By.xpath("//*[@class='product-information']"));
        Assert.assertTrue(urunAyrintiSayfasi.isDisplayed());



    }
}
