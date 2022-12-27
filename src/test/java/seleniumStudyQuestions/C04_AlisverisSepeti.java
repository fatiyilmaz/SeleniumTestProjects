package seleniumStudyQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_AlisverisSepeti {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. "https://www.saucedemo.com/" Adresine gidin
        driver.get("https://www.saucedemo.com/");

        //2. Username kutusuna "standard_user" yazdirin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");

        //3. Password kutusuna "secret_sauce" yazdirin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");

        //4. Login tusuna basin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='login-button']")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
//        WebElement ilkUrun = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
//        System.out.println(ilkUrun.getText());
//        ilkUrun.click();
        driver.findElement(By.xpath("//*[@src='/static/media/sauce-backpack-1200x1500.34e7aa42.jpg'][1]")).click();




        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();

        //7. Alisveris sepetine tiklayin
        WebElement sepet = driver.findElement(By.xpath("//*[@class='shopping_cart_badge']"));
        sepet.click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement kontrol = driver.findElement(By.xpath("//*[@class='cart_item']"));
        if (kontrol.isDisplayed()){
            System.out.println("Kontrol PASSED : "+kontrol.getText());
        }else{
            System.out.println("Kontrol FAILED : "+kontrol.getText());
        }


    }
}
