package seleniumStudyQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class C07_Dropdown {

    /*
       1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
       2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
       3-Option3 ü seçin.
       4-Option3 ün seçili olduğunu doğrulayın.
*/

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test(){

        //1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        //2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
        //3-Option3 ü seçin.
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown-class-example']"));
        Assert.assertTrue(ddm.isDisplayed());
        Select option3 = new Select(ddm);
        option3.selectByVisibleText("Option3");

        //4-Option3 ün seçili olduğunu doğrulayın.
        String option3SeciliMi = option3.getFirstSelectedOption().getText();
        Assert.assertEquals("Option3",option3SeciliMi);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
