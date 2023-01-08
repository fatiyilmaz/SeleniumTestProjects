package seleniumStudyQuestions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import unitilities.Main;

public class C12_WindowHandleDrang_And_Drop extends Main {
    @Test
    public void WindowHandleDrang_And_DropTest() throws InterruptedException {
        // /*
        //  #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // #Fill in capitals by country
        //*/
        //  /*
        //   #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        //  #Ülkeye göre başkentleri doldurun
        // */


        for (int i = 1; i <=7; i++) {
            WebElement kaynak = driver.findElement(By.id("box"+i));
            WebElement hedef = driver.findElement(By.id("box"+(100+i)));
            Actions actions = new Actions(driver);
            actions.dragAndDrop(kaynak,hedef).perform();
        }

        Thread.sleep(3000);







    }


}
