package pdfQuestions;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import unitilities.Main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DenemeScreenshots1 extends Main {

    @Test
    public void screenshotsTest() throws IOException {
        driver.get("https://www.ciceksepeti.com");
        //driver.findElement(By.xpath("(//*[@class='item-image item-flower'])[1]"));

        File fullScreenAnasayfa = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDate = new SimpleDateFormat("ssmmddMMyyyy").format(new Date());
        String path = System.getProperty("user.dir")+"/team07/EkranGoruntusu/"+currentDate+"image.png";
        File hedef = new File(path);

        FileUtils.copyFile(fullScreenAnasayfa,hedef);







    }
}
