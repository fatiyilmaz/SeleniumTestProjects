package pdfQuestions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Syf26_ManageWindowSet {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //2. Sayfanin konumunu ve boyutlarini yazdirin
        Thread.sleep(3000);
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        //3. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        Thread.sleep(3000);
        driver.manage().window().setPosition(new Point(90,80));
        driver.manage().window().setSize(new Dimension(900,800));

        //4. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        int x = driver.manage().window().getPosition().x;
        int y = driver.manage().window().getPosition().y;
        int genislik = driver.manage().window().getSize().width;
        int yukseklik = driver.manage().window().getSize().height;
        if (x==90&&y==80&&genislik==900&&yukseklik==800){
            System.out.println("Sayfanin konum ve boyutu PASSED");
        }else{
            System.out.println("Sayfanin konum ve boyutu FAILED");
        }

        //5. Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();



    }
}

