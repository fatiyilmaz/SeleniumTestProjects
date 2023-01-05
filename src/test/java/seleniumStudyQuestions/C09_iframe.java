package seleniumStudyQuestions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import unitilities.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class C09_iframe extends Main {
    @Test
    public void iframe() throws InterruptedException {

        // go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");



        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();



        // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement> tumOgeler = driver.findElements(By.xpath("//*[@id='nature']//img"));
        tumOgeler.stream().forEach(WebElement::click);
        Thread.sleep(3000);


        // ana iframe'e geri dön
        driver.switchTo().parentFrame();

        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> list = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String> veriler = new ArrayList<>(Arrays.asList("Erol","Evren","selenium","lambda","java","sql","gitgithub","dff","Sadgas","sdags","asdads"));

        for (int i = 0; i < list.size(); i++) {
            list.get(i).sendKeys(veriler.get(i));
        }

        // uygula butonuna tıklayın
        driver.findElement(By.xpath("//*[@id='send']")).click();
        Thread.sleep(3000);





    }







}
