package seleniumStudyQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_TelefolariSepeteEkleme {
    /*
1~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
2~ click on Phones & PDAs
3~ get the brandName of phones
4~ click on add to button for all elements
5~ click on black total added cart button
6~ get the names of list from the cart
7~ compare the names from displaying list and cart list
 */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        //2
        driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();
        //3
        List<WebElement> phoneNames = driver.findElements(By.xpath("//h4"));
        for (WebElement w : phoneNames){
            System.out.println(w.getText());
        }
        //4
        List<WebElement> ogeleriEkle = driver.findElements(By.xpath("//*[text()='Add to Cart']"));
        for (WebElement w: ogeleriEkle){
            w.click();
        }
        //5
        driver.findElement(By.xpath("//*[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();
        //6
        System.out.println("=============");
        List<WebElement> listNames = driver.findElements(By.xpath("//*[@class='text-left']"));
        for (WebElement w:listNames){
            System.out.print(w.getText());
        }
        //7
        if (phoneNames.equals(listNames)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");
        //8
        driver.quit();
    }
}

//     1~ http://tutorialsninja.com/demo/index.php?route=common/home adresine gidin
//     2~ Telefonlar ve PDA'lara tıklayın
//     3~ telefonların markasını alın
//     4~ tüm öğeler için ekle düğmesine tıklayın
//     5~ siyah toplam eklenen sepet düğmesine tıklayın
//     6~ sepetten listenin isimlerini al
//     7~ görüntüleme listesindeki ve sepet listesindeki adları karşılaştırın

