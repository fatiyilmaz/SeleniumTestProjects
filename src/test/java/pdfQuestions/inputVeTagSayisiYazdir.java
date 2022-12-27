package pdfQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class inputVeTagSayisiYazdir { //            WebElementMethods
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //trendyol git
        driver.get("https://www.trendyol.com");

        //Search bolumunu locate edelim ve Search bolumunde hamburger aratalim
        driver.findElement(By.className("vQI670rJ")).sendKeys("hamburger", Keys.ENTER);

        //trendyol da goruntulenen ilgili sonuclarinin sayisini yazdirin
        List<WebElement> aramaSayisi = driver.findElements(By.className("dscrptn"));
        System.out.println(aramaSayisi.size());
        for (WebElement w: aramaSayisi){
            System.out.println(w.getText());
        }

        //Karsiniza cikan ilk sonucun resmine tiklanayiniz
        //driver.findElement(By.className("image-overlay-body")).click();

        //Onerilenler kismindaki secenekleri yazdirin
        List<WebElement> onerilenler = driver.findElements(By.className("sort-fltr-cntnr"));
        //System.out.println(onerilenler.size());
        for (WebElement w: onerilenler){
            System.out.println(w.getText());
        }

        //Trendyol sayfasindaki <input> ve <a> tag'larinin sayisini yazdiriniz

        List<WebElement> listeler = driver.findElements(By.tagName("input"));
        System.out.println("Input Tag Sayisi = " + listeler.size());

        List<WebElement> linkler = driver.findElements(By.tagName("a"));
        System.out.println("Link Sayisi = " + linkler.size());
        for (WebElement f : linkler) {
            System.out.println(f.getText());


        }

    }
}

