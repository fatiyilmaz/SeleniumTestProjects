package pdfQuestions;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import unitilities.Main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DenemeScreenshots2 extends Main {
    @Test
    public void webElementGoruntu() throws IOException {
        driver.get("https://www.techproeducation.com");

        WebElement logo = driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
        File image = logo.getScreenshotAs(OutputType.FILE);
        String currentDate = new SimpleDateFormat("ssmmddMMyyyy").format(new Date());
        String path = System.getProperty("user.dir")+"/test/logoGoruntu/"+currentDate+"image.png";
        File hedef = new File(path);
        FileUtils.copyFile(image,hedef);

    }
}
