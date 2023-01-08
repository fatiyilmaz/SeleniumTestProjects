package seleniumStudyQuestions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import unitilities.Main;

public class C12_Hover_Over extends Main {

    @Test
    public void Hover_Over() throws InterruptedException {

        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirst = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMeFirst).perform();
        Thread.sleep(3000);

        //3. "Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//*[@href='#'])[1]"));
        actions.moveToElement(link1).click().build().perform();
        Thread.sleep(3000);


        //4. Popup mesajini yazdirin
        System.out.println("Popup Mesaji : "+driver.switchTo().alert().getText());


        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();


        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickAndHold).perform();
        Thread.sleep(3000);


        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());


        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickMe = driver.findElement(By.xpath("//*[@id='double-click']"));
        actions.doubleClick(doubleClickMe).perform();
        Thread.sleep(3000);


        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        WebElement turuncu = driver.findElement(By.xpath("//*[@id='double-click']"));//yukarida turuncu, yesil oldu
        WebElement yesil = driver.findElement(By.xpath("//*[@class='div-double-click double']"));

        Assert.assertEquals(yesil,turuncu);


    }
}
